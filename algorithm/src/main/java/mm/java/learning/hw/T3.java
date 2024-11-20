package mm.java.learning.hw;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName mm.java.learning.hw.T3
 * @Description 火锅
 * @Author mars
 * @Date 2024/11/20 9:18
 * @Version 1.0
 **/
public class T3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr[i] = x + y;
        }
        Arrays.sort(arr);

        int res = 0;
        int now = 0, idx = 0;
        while (idx < n) {
            if (arr[idx] >= now) {
                now = arr[idx] + m;
                res++;
            }

            idx++;
        }

        System.out.println(res);
    }

}
