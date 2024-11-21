package mm.java.learning;

import java.util.ArrayList;

/**
 * @ClassName HeapOverFlow
 * @Description 堆溢出
 * @Author mars
 * @Date 2024/11/14 21:54
 * @Version 1.0
 **/
public class HeapOverFlow {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        while (true) {
            objects.add(new Object());
        }
    }

}
