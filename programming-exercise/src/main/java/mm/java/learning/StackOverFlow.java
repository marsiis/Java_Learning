package mm.java.learning;

/**
 * @ClassName StackOverFlow
 * @Description 栈溢出
 * @Author mars
 * @Date 2024/11/14 21:58
 * @Version 1.0
 **/
public class StackOverFlow {
    public static void main(String[] args) {
        recursiveMethod(1);
    }

    private static void recursiveMethod(int i) {
        recursiveMethod(i);
    }

}
