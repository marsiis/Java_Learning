package mm.java.learning;

/**
 * @ClassName ParseInt
 * @Description parseInt()：用于将字符串参数作为有符号的十进制整数进行解析。
 * 如果方法有两个参数，使用第二个参数指定的基数，将字符串参数解析为有符号的整数。
 * @Author mars
 * @Date 2024/11/14 12:18
 * @Version 1.0
 **/
public class ParseInt {
    public static void main(String[] args) {
        // 所有Number派生类parseInt方法格式类似如下
        // static int parseInt(String s)
        // static int parseInt(String s, int radix)

        // s -- 十进制表示的字符串
        // radix -- 指定的基数

        int x = Integer.parseInt("9");
        double c = Double.parseDouble("5");
        int b = Integer.parseInt("444", 16);

        System.out.println(x); // 9
        System.out.println(c); // 5.0
        System.out.println(b); // 1092
    }

}
