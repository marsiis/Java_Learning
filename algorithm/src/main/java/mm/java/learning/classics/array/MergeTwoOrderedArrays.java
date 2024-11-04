package mm.java.learning.classics.array;

/**
 * @ClassName MergeTwoOrderedArrays
 * @Description 力扣88. 合并两个有序数组
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
