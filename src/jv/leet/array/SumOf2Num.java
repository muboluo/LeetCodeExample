package jv.leet.array;

import com.sun.prism.shader.Solid_TextureYV12_AlphaTest_Loader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 与查找 括号类似
 */

class SumOf2Num {

    public static int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> valueIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int anotherValue = target - nums[i];
            if (valueIndexMap.containsKey(anotherValue)) {
                return new int[]{i, valueIndexMap.get(anotherValue)};
            } else {
                valueIndexMap.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};

    }

    private static int[] twoSum5(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[]{-1, -1};
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int anotherValue = target - nums[i];
            if (map.containsKey(anotherValue)) {
                return new int[]{i, map.get(anotherValue)};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        final int[] resultArray = twoSum(new int[]{2, 7, 11, 8, 15}, 10);
        System.out.println(resultArray[0] + "   " + resultArray[1]);

        twoSum2(new int[]{2, 7, 11, 8, 15}, 10);
        twoSum3(new int[]{2, 7, 11, 8, 15}, 10);
        twoSum4(new int[]{2, 7, 11, 8, 15}, 10);
    }

    // 两数之和 取出对应的index 第四遍
    private static int[] twoSum4(int[] nums, int target) {

        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length <= 1) {
            return result;
        }

        Map<Integer, Integer> numIndexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int another = target - nums[i];

            if (numIndexMap.containsKey(another)) {
                result[0] = numIndexMap.get(another);
                result[1] = i;
                break;
            } else {
                numIndexMap.put(nums[i], i);
            }
        }
        System.out.println(Arrays.toString(result));
        return result;
    }

    // 两数之和 存储对应的index - 第三次
    private static int[] twoSum3(int[] nums, int target) {

        int[] resultArray = new int[]{-1, -1};
        if (nums == null) {
            return resultArray;
        }

        // 将 数组中的value 作为 key， index 作为value。存储在map中，当满足key的规则时，将value取出来。
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {

            int anotherNum = target - nums[i];
            if (map.containsKey(anotherNum)) {

                resultArray[0] = map.get(anotherNum);
                resultArray[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        System.out.println(Arrays.toString(resultArray));
        return resultArray;
    }

    // 两数之和 取出对应的index - 第二次
    private static int[] twoSum2(int[] nums, int target) {

        int[] resultArray = new int[]{-1, -1};

        if (nums == null) {
            return resultArray;
        }

        // 目标，把 数组的index，放到 以数组中的值作为 key 的 map 的value中。
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {

            int anotherNum = target - nums[i];
            if (!map.containsKey(anotherNum)) {
                map.put(nums[i], i);
            } else {

                resultArray[0] = map.get(anotherNum);
                resultArray[1] = i;
                break;
            }
        }

        System.out.println(Arrays.toString(resultArray));
        return resultArray;
    }

}
