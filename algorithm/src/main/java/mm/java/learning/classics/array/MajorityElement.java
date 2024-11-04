package mm.java.learning.classics.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName MajorityElement
 * @Description 给定一个大小为n的数组nums，返回其中的多数元素。多数元素是指在数组中出现次数大于[n/2]的元素。你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * @Author mars
 * @Date 2024/11/4 14:07
 * @Version 1.0
 **/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = counts(nums);
        Map.Entry<Integer, Integer> majorityEntry = null;
        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (majorityEntry == null || entry.getValue() > majorityEntry.getValue()) {
                majorityEntry = entry;
            }
        }
        return majorityEntry.getKey();
    }

    private Map<Integer, Integer> counts(int[] nums) {
        Map<Integer, Integer> countNums = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (!countNums.containsKey(num)) {
                countNums.put(num, 1);
            } else {
                countNums.put(num, countNums.get(num) + 1);
            }
        }
        return countNums;
    }
}
