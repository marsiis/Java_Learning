package mm.java.learning;

/**
 * @ClassName LastIndexOf
 * @Description lastIndexOf()用法
 * @Author mars
 * @Date 2024/11/14 9:00
 * @Version 1.0
 **/
public class LastIndexOf {
    public static void main(String[] args) {
        char a = Character.toLowerCase('A');
        

        // public int lastIndexOf(int ch):返回指定字符在此字符串中最后一次出现处的索引位置，如果此字符串中没有这样的字符，则返回-1

        // public int lastIndexOf(int ch, int fromIndex):返回指定字符在此字符串中最后一次出现处的索引，从指定索引处开始进行反向搜索，如果此字符串中没有这样的字符，则返回-1

        //public int lastIndexOf(String str):返回指定字符串在此字符串中最右边出现处的索引，如果此字符串中没有这样的字符，则返回-1

        // public int lastIndexOf(String str, int fromIndex):返回指定字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索，如果此字符串中没有这样的字符，则返回-1

        String str = "华为机考：start.stop.pass";
        String str1 = "start";
        String str2 = "stop";

        System.out.print("查找字符 o 最后出现的位置");
        System.out.println(str.lastIndexOf('o')); // 13

        System.out.print("从第10个位置查找字符 t 最后出现的位置");
        System.out.println(str.lastIndexOf('t', 10)); // 9

        System.out.print("子字符串 str1 最后出现的位置");
        System.out.println(str.lastIndexOf(str1)); // 5

        System.out.print("从第10个位置开始搜索子字符串 str1 最后出现的位置");
        System.out.println(str.lastIndexOf(str1, 10)); // 5

        System.out.print("子字符串str2最后一次出现的位置");
        System.out.println(str.lastIndexOf(str2)); // 11
    }
}

