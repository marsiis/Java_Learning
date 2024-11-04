package mm.java.learning.classics.array;

/**
 * @ClassName RemoveDuplicates
 * @Description 给你一个有序数组nums，请你原地删除重复出现的元素，使得出现次数超过两次的元素只出现两次，返回删除后数组的新长度。不要使用额外的数组空间，你必须在原地修改输入数组并在使用O(1)额外空间的条件下完成。
 * @Author mars
 * @Date 2024/11/4 13:02
 * @Version 1.0
 **/
public class RemoveDuplicates2 {
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int fast = 2, slow = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
