package jv.leet.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 */

class SumOf2Num {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> sumMap = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {

            int complement = target - nums[i];
            if (sumMap.containsKey(complement)) {
                return new int[]{sumMap.get(complement), i};
            }
            sumMap.put(nums[i], i);
        }

        throw new IllegalArgumentException("no tow sum solution");

    }

}
