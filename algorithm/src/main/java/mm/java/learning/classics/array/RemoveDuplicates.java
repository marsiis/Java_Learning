package mm.java.learning.classics.array;

/**
 * @ClassName RemoveDuplicates
 * @Description 给你一个非常严格递增排列的数组nums，请你原地删除重复出现的元素，使每个元素只出现一次，返回删除后数组的新长度。元素的相对顺序应该保持一致。然后返回nums中唯一元素的个数。
 * @Author mars
 * @Date 2024/11/4 13:02
 * @Version 1.0
 **/
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int fast = 1, slow = 1;
        while (fast < n) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
