package mm.java.learning.classics.array;

/**
 * @ClassName MergeTwoOrderedArrays
 * @Description 给你两个按非递减顺序排列的整数数组nums1和nums2，另外有两个整数整数m和n，分别表示nums1和nums中的元素数目。请你合并nums2到nums1中，使合并后的数组同样按非递减顺序排列。
 * Attention：最终，合并后数组不应由函数返回，而是存储在数组nums1中。为了应对这种情况，nums1的初始长度为m + n,其中前m个元素表示应合并的元素，后n个元素为0，应忽略。nums2的长度为n。
 * @Author mars
 * @Date 2024/11/4 11:38
 * @Version 1.0
 **/
public class MergeTwoOrderedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail = nums1.length - 1;
        int i1 = m - 1;
        int i2 = n - 1;
        while (i1 != -1 || i2 != -1) {
            if (i1 == -1) {
                nums1[tail] = nums2[i2--];
            } else if (i2 == -1) {
                nums1[tail] = nums1[i1--];
            } else if (nums1[i1] > nums2[i2]) {
                nums1[tail] = nums1[i1--];
            } else {
                nums1[tail] = nums2[i2--];
            }
            tail--;
        }
    }
}
