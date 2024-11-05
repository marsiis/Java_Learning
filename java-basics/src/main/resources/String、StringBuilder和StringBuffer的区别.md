String是不可变的，StringBuilder和StringBuffer是可变的。而StringBuilder是非线程安全的。

# String是如何实现不可变的？
1. String类被声明为final，这意味着它不能被继承。那么它里面的方法就是没有办法被覆盖的。
2. 用final修饰字符串内容的char[]（从JDK9开始，char[]变成了byte[]），由于该数组被声明为final，一旦数组被初始化，就不能再指向其他数组。
3. String类没有提供用于修改字符串内容的公共方法。例如，没有提供用于追加、删除或修改字符的方法。如果需要对字符串进行修改，会创建一个新的String对象。
---
String源码中提供的一些方法，如substring、concat等，在代码中如果涉及到字符串的修改，也是通过new String()的方式新建了一个字符串。

所以，一个字符串的内容，一旦被创建出来了，就是不可以修改了。

>不可变对象是在完全创建后其内部状态保持不变的对象，这意味着，一旦对象被赋值给变量，我们既不能更新引用，也不能通过任何方式改变其内部状态。

## 为什么JDK9中把String的char[]改成了byte[]?
由于Java内部使用UTF-16，每个char占据两个字节，即使某些字符可以用一个字节(LATIN-1)表示，但是也仍然会占用两个字节。所以，JDK9就对此做了优化。

java9引入了"**Compact String**"的概念：

每当我们创建一个字符串时，如果它的所有字符都可以用单个字节（Latin-1）表示，那么将会在内部使用字节数组来保存一半所需的空间，但是如果有一个字符需要超过8位来表示，Java将继续使用UTF-16与字符数组。

> Latin1（又称ISO 8859-1）是一种字符编码格式，用于表示西欧语言，包括英语、法语、德语、西班牙语、葡萄牙语、意大利语等。它由国际标准化组织（ISO）定义，并涵盖了包括ASCII在内的128个字符。

>Latin1编码使用单个字节编码方案，也就是说每个字符只占用一个字节，其中第一位固定位0，后面的七位可以表示128个字符。这样，Latin1编码可以很方便地与ASCII兼容。

所有字符串操作时，它如何区分到底用Latin-1还是UTF-16表示呢？

为了解决这个问题，对String的内部实现进行了另一个更改。引入了一个名为coder的字段，用于保存这些信息。

## String为什么设计成不可变的？
主要从缓存、安全性、线程安全和性能角度出发的。
### 缓存
字符串是使用最广泛的数据结构。大量字符串的创建是非常耗资源的，所以，Java提供了对字符串的缓存功能，可以大大的节省堆空间。

JVM中专门开辟了一部分空间来存储Java字符串，那就是字符串池。

通过字符串池，两个内容相同的字符串变量，可以从池中指向同一个字符串对象，从而节省了关键内存资源。

但是，之所以可以这么做，主要是因为字符串的不可变性。

### 安全性
字符串在Java应用程序中广泛用于存储敏感信息，如用户名、密码、连接url、网络连接等。JVM类加载器在加载类的时候也广泛使用它。

因此保护String类对于提升整个应用的安全性至关重要。

当我们在程序中传递一个字符串的时候，如果这个字符串的内容是不可变的，那么我们就可以相信 这个字符串中的内容。

但是，如果是可变的，那么这个字符串内容就可能随时被修改。那么这个字符串内容就完全不可信了。这样整个系统就没有安全性可言了。

### 线程安全
不可变会自动使字符串成为线程安全的，因为当多个线程访问它们时，它们不会被更改。

因此一般来说，不可变对象可以同时运行在多个线程之间共享。它们也是线程安全的，因为如果线程更改了值，那么将会在字符串池中创建一个新的字符串，而不是修改相同的值。因此，字符串相对于多线程是安全的。

### hashcode缓存
由于字符串被广泛的用作数据结构，他们也被广泛的用于hash实现，如HashMap、HashTable、HashSet等。在对这些散列实现进行操作时，经常调用hashCode()方法。

不可变性保证了字符串的值不会改变。因此，HashCode()方法在String类中被重写，以方便缓存，这样在第一次hashCode()调用期间计算和缓存散列，并从那时起返回相同的值。

### 性能
前面提到了字符串池、hashCode缓存等，都是提升性能的体现。

因为字符串不可变，所以可以用字符串池缓存，可以大大节省堆内存。而且还可以提前对hashCode进行缓存，更加高效。

由于字符串是应用最广泛的数据结构，提高字符串的性能对提高整个应用程序的总体性能有相当大的影响。

### String的"+"是如何实现的
使用+拼接字符串，其实只是Java提供的一个语法糖，那么，我们就来解一解这样语法糖，看看他的内部原理到底是如何实现的。

我们把它生成的字节码进行反编译，看看结果。
```java
String wechat = "Hollis";
String introduce = "Chuang";
String hollis = wechat + "," + introduce;
```
反编译后的内容如下，反编译工具为jad。

```java
String wechat = "Hollis";
String introduce = "Chuang";
String hollis = (new StringBuilder().append(wechat).append(",").append(introduce).toString());
```

通过查看反编译以后的代码，我们可以发现，原来字符串常量在拼接过程中，是将String转成了StringBuilder后，使用其append方法进行处理的。

那么也就是说，Java中的+对字符串的拼接，其实现原理是使用StringBuilder.append。

### StringBuffer和StringBuilder
接下来我们看看StringBuffer和StringBuilder的实现原理。

和String类类似，StringBuilder类也封装了一个字符数组，定义如下：
```java
char[] value;
```
与String不同的是，他并不是final的，所以它是可以修改的。另外，与String不同，字符数组中不一定所有位置都已经被使用，它有一个实例变量，表示数组中已经使用的字符个数，定义如下：
```java
int count;
```
其append源码如下：
```java
public StringBuilder append(String str) {
    super.append(str);
    return this;
}
```
该类继承了`AbstractStringBuilder`类，看下`append`方法：
```java
public AbstractStringBuilder append(String str) {
    if (str == null) {
        return appendNull();
    }
    int len = str.length();
    ensureCapacityInternal(count + len);
    str.getChars(0, len, value, count);
    count += len;
    return this;
}
```
append会直接拷贝字符到内部字符数组中，如果字符串数组长度不够，会进行扩展。

StringBuffer和StringBuilder类似，最大的区别就是StringBuffer是线程安全的，看一下StringBuffer的`append`方法。

```JAVA
public synchronized StringBuffer append(String str) {
    toStringCache = null;
    super.append(str);
    return this;
}
```
该方法使用synchronized进行声明，说明是一个线程安全的方法。而StringBuilder则不是线程安全的。

### 不要在for循环中使用+拼接字符串
前面我们分析过，其实使用`+`拼接字符串的实现原理也是使用`StringBuilder`，那为什么不建议大家在for循环中使用呢？

在for循环中，每次都是new了一个StringBuilder，然后再把String转成StringBuilder,再进行append。

而频繁的新建对象当然要耗费很多时间了，不仅会耗费时间，频繁地创建对象，还会造成内存资源的浪费。

所以，阿里巴巴Java开发手册建议：循环体内，字符串的连接方式，使用StringBuilder的append方法进行扩展，而不要使用`+`。

### JDK9对字符串的拼接做了什么优化?
在JDK9之前，字符串拼接通常使用`+`进行，`+`的实现其实是基于StringBuilder的。

引入StringConcatFactory，是基于invokeDynamic指令实现的。

> 是Java7引入的一种动态类型指令，允许JVM在运行时动态解析和调用方法。

这就使得JVM可以在运行时根据实际场景选择最优的拼接策略，可能是StringBuilder、StringBuffer或者其他更高效的方法。

