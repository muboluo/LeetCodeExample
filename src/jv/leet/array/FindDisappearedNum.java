package jv.leet.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
 * <p>
 * 示例 1：
 * 输入：nums = [4,3,2,7,8,2,3,1]
 * 输出：[5,6]
 * 鸽笼原理
 * <p>
 * 链接：https://leetcode.cn/problems/find-all-numbers-disappeared-in-an-array/solution/zhao-dao-suo-you-shu-zu-zhong-xiao-shi-d-mabl/
 */
public class FindDisappearedNum {

    public static void main(String[] args) {

        List<Integer> ints = findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});
        System.out.println(ints.toString());
    }

    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int num : nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                ret.add(i + 1);
            }
        }
        return ret;
    }

    public static List<Integer> findDisappearedNumbers2(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        int n = nums.length;
        for (int num : nums) {
            int index = (num - 1) % n;
            nums[index] += n;
        }

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }

        return result;
    }

    public static List<Integer> findDisappearedNumbers3(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int index = (nums[i] - 1) % len;
            nums[index] += len;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; i++) {

            if (nums[i] < len) {
                result.add(i);
            }
        }
        return result;
    }
}
