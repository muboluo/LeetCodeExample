package jv.leet.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * <p>
 * 解题思路：
 * 标签：数组遍历
 * 首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，再使用左右指针指向 nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，计算三个数的和
 * sumsum 判断是否满足为 00，满足则添加进结果集
 * 如果 nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
 * 如果 nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
 * 当 sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++
 * 当 sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R--
 * 时间复杂度：O(n^2)，n 为数组长度
 */
class FifthSumOfThreeNums {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        int len = nums.length;

        if (len < 3) {
            return ans;
        }

        Arrays.sort(nums);

        int l = 0;
        int r = 0;

        for (int i = 0; i < len; ++i) {
            if (nums[i] > 0) {
                return ans;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            l = i + 1;
            r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                } else if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                }
            }

        }

        return ans;

    }
}