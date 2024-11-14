package mm.java.learning;

/**
 * @ClassName Substring
 * @Description substring用法
 * @Author mars
 * @Date 2024/11/14 11:52
 * @Version 1.0
 **/
public class Substring {
    public static void main(String[] args) {
        // public String substring(int beginIndex)

        // public String substring(int beginIndex, int endIndex)

        // beginIndex -- 起始索引（包括），索引从0开始
        // endIndex -- 结束索引（不包括）

        String str = "This is a text";

        System.out.print("返回值：");
        System.out.println(str.substring(5));

        System.out.print("返回值：");
        System.out.println(str.substring(5, 10));
    }
}
