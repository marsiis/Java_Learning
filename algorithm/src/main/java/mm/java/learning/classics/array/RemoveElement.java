package mm.java.learning.classics.array;

/**
 * @ClassName RemoveElement
 * @Description 力扣27. 移除元素
 * @Author mars
 * @Date 2024/11/4 12:37
 * @Version 1.0
 **/
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }
}
