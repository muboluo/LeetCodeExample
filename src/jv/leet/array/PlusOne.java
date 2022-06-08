package jv.leet.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/plus-one/solution/jia-yi-by-leetcode-solution-2hor/
 * <p></p>
 * 加 1，数组表示非负数， 最后一位是低位， 最后一位+1
 * <p></p>
 * 解法1： 数 9
 * <p></p>
 * 解法2：判断 +1 之后的 0
 */
public class PlusOne {

    // 数9 -1
    public static int[] plus11(int[] nums) {

        if (nums == null) {
            return null;
        }
        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] != 9) {

                nums[i]++;

                for (int j = i + 1; j < nums.length; j++) {
                    nums[j] = 0;
                }

                return nums;
            }

        }

        int[] newNums = new int[nums.length + 1];
        newNums[0] = 1;
        return newNums;
    }

    // +1 之后 0 的判断。
    public static int[] plus21(int[] nums) {

        if (nums == null) {
            return null;
        }

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] != 9) {
                nums[i]++;

                for (int j = i + 1; j < nums.length; j++) {
                    nums[j] = 0;
                }
                return nums;
            }
        }

        int[] newNums = new int[nums.length + 1];
        newNums[0] = 1;
        return newNums;

    }

    // +1 plus one, 数组代表数字，最后一位 +1.  对最后几位 9 的判断
    public static int[] plus31(int[] nums) {

        if (nums == null) {
            return nums;
        }

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] != 9) {
                nums[i]++;

                for (int j = i + 1; j < nums.length; j++) {
                    nums[j] = 0;
                }
                return nums;
            }
        }

        int[] newNums = new int[nums.length + 1];
        newNums[0] = 1;
        return newNums;
    }

    // 数9 -2
    public static int[] plus12(int[] nums) {

        for (int i = nums.length - 1; i >= 0; i--) {

            // handle current level
            nums[i] = (nums[i] + 1) % 10;

            if (nums[i] != 0) {
                return nums;
            }
        }

        int[] newNums = new int[nums.length + 1];
        newNums[0] = 1;
        return newNums;

    }

    //  +1 之后，判断0 第二遍
    public static int[] plus22(int[] nums) {

        if (nums == null) {
            return null;
        }

        for (int i = nums.length - 1; i >= 0; i--) {

            nums[i] = (nums[i] + 1) % 10;

            if (nums[i] != 0) {
                return nums;
            }
        }

        int[] newNums = new int[nums.length + 1];
        newNums[0] = 1;
        return newNums;
    }


    // +1 数组表述数字。最后一位 + 1. +1 法
    public static int[] plus32(int[] nums) {


        if (nums == null) {
            return nums;
        }

        for (int i = nums.length - 1; i >= 0; i--) {

            nums[i] = (nums[i] + 1) % 10;
            if (nums[i] != 0) {
                return nums;
            }
        }

        int[] newNums = new int[nums.length + 1];
        newNums[0] = 1;
        return newNums;
    }


    public static void main(String[] args) {

        System.out.println(Arrays.toString(plus11(new int[]{1, 2, 3, 4, 9, 9, 9, 9})));
        System.out.println(Arrays.toString(plus12(new int[]{1, 2, 3, 4, 9, 9, 9, 9})));
        System.out.println(Arrays.toString(plus21(new int[]{1, 2, 3, 4, 9, 9, 9, 9})));
        System.out.println(Arrays.toString(plus22(new int[]{1, 2, 3, 4, 9, 9, 9, 9})));
        System.out.println(Arrays.toString(plus31(new int[]{1, 2, 3, 4, 9, 9, 9, 9})));
        System.out.println(Arrays.toString(plus32(new int[]{1, 2, 3, 4, 9, 9, 9, 9})));

    }
}
