package jv.leet.array;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 来源：力扣（LeetCode）
 * <p>
 * 链接：https://leetcode-cn.com/problems/3sum
 * <p>
 * 解题思路：
 * <p>
 * 标签：数组遍历
 * <p>
 * 首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，再使用左右指针指向 nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，计算三个数的和
 * sumsum 判断是否满足为 00，满足则添加进结果集
 * <p>
 * 如果 nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
 * 如果 nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
 * <p>
 * 当 sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++
 * 当 sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R--
 * <p>
 * 时间复杂度：O(n^2)，n 为数组长度
 */
class SumOfThreeNums {

    public static void main(String[] args) {

        threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("-------------");
        threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("-------------");
        threeSum3(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("-------------");
    }

    // 三数之和 - 第三遍
    private static List<List<Integer>> threeSum3(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // terminal
        if (nums == null || nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);

        int l = 0, r = nums.length - 1;
        // for loop
        for (int i = 0; i < nums.length; i++) {

            // for terminal
            if (nums[i] > 0) {
                break;
            }

            // for terminal
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            l = i + 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }

                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }

        }

        for (List<Integer> list :
                result) {

            System.out.println(Arrays.toString(list.toArray()));
        }


        return result;
    }

    private static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        //1 set terminal
        if (nums == null || nums.length < 3) {
            return result;
        }


        // 2 sort
        Arrays.sort(nums);


        // 3 handle current level
        int l, r = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {


            // 4 terminal
            if (nums[i] > 0) {
                break;
            }

            // 5 no repeat, jump next level
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            l = i + 1;
            while (l < r) {

                int sum = nums[l] + nums[i] + nums[r];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[l], nums[i], nums[r]));
                    // jump next level
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }

                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }

                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        for (List<Integer> ints :
                result) {
            System.out.println(Arrays.toString(ints.toArray()));
        }
        return result;
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        // 1 terminal clause
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        int len = nums.length;

        if (len < 3) {
            return ans;
        }

        // 2 排序
        Arrays.sort(nums);

        int l = 0;
        int r = 0;

        // 3 loop current
        for (int i = 0; i < len; ++i) {
            // 4. terminal clause
            if (nums[i] > 0) {
                break;
            }

            // 5. jump next i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 6. handle current level
            l = i + 1;
            r = len - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    // 7. jump next level
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    // 8. jump next level from left
                    l++;
                } else if (sum > 0) {
                    // 9. jump next level from right
                    r--;
                }
            }

        }

        for (List<Integer> ints :
                ans) {
            System.out.println(Arrays.toString(ints.toArray()));
        }
        return ans;
    }
}