package mm.java.learning;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            in.nextLine();
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                String[] sa = s.split(" ");
                int key = Integer.parseInt(sa[0]);
                int value = Integer.parseInt(sa[1]);
                map.put(key, map.getOrDefault(key, 0) + value);
            }
            for (Map.Entry<Integer, Integer> res : map.entrySet()) {
                System.out.println(res.getKey() + " " + res.getValue());
            }
        }
    }
}