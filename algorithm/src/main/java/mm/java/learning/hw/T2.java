package mm.java.learning.hw;

import java.util.*;

/**
 * @ClassName mm.java.learning.hw.T2
 * @Description 字符统计及重排
 * @Author mars
 * @Date 2024/11/20 9:00
 * @Version 1.0
 **/
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char ch : line.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> items = new ArrayList(map.entrySet());
        items.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (!Objects.equals(o1.getValue(), o2.getValue())) return o2.getValue() - o1.getValue();
                else return o1.getKey() - o2.getKey();
            }
        });

        for (Map.Entry<Character, Integer> entry : items) {
            System.out.print(entry.getKey() + ":" + entry.getValue() + ";");
        }
        System.out.println();
    }

}
