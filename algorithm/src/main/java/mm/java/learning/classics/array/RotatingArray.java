package mm.java.learning.classics.array;

/**
 * @ClassName RotatingArray
 * @Description 给定一个整数数组nums，将数组中的元素向右轮转k个位置，其中k是非负数。
 * @Author mars
 * @Date 2024/11/5 7:22
 * @Version 1.0
 **/
public class RotatingArray {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
