package mm.java.learning;

import java.util.Scanner;

/**
 * @ClassName Main
 * @Description 牛客刷题模板类
 * @Author mars
 * @Date 2024/11/15 9:48
 * @Version 1.0
 **/
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            System.out.println(toIntAddress(sc.next()));
            System.out.println(toIpAddress(sc.next()));
        }
    }

    public static String toIntAddress(String address) {
        String[] sa = address.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String s : sa) {
            String binaryString = Integer.toBinaryString(Integer.parseInt(s));
            binaryString = toBinary(binaryString);
            sb.append(binaryString);
        }
        int i = Integer.parseInt(sb.toString(), 2);
        return String.valueOf(i);
    }

    public static String toIpAddress(String address) {
        String binaryString = Integer.toBinaryString(Integer.parseInt(address));
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            sb.append(Integer.parseInt(binaryString.substring(index, 8), 2));
            index = index + 8;
            if (i != binaryString.length() - 1) {
                sb.append(".");
            }
        }
        return sb.toString();
    }

    public static String toBinary(String binaryString) {
        if (binaryString.length() < 8) {
            StringBuilder sb = new StringBuilder(8); // 预先分配足够的空间
            for (int i = 0; i < 8 - binaryString.length(); i++) {
                sb.append('0');
            }
            sb.append(binaryString);
            return sb.toString();
        }
        return binaryString;
    }
}