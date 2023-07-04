package jv.leet.array;

/**
 * 题目要求： 将 一个有序数组中，删除相同项，并计算出非重复数据的长度。
 * 地址：https://leetcode-cn.com/problems/move-zeroes/submissions/
 * 思路： 采用双指针法，增加维度。
 * 1 一个慢指针，一个快指针。 从0开始判断。因为数组有序，所以如果有相同项，他们肯定是相邻的。
 * 所以现在有两种情况：
 * ① nums[i] 与 nums[j]之间没有重复项
 * ② nums[i] 与 nums[j]之间有重复项
 * <p>
 * ① 若 nums[i] 与 nums[j] 之间有重复项：
 * nums[i+1] 为第一个出现重复项的位置。使用 nums[j] 覆盖 nums[i+1]，这样就消除了nums[i] != nums[i+1],从第一项至 i 项就没有了重复项。
 * j++ 之后，继续判断，若二者相同，j继续后移，寻找下一个不同的数值。若二者不同，则将新的数值存储至 nums[i+1]中。
 *
 * @ 若 nums[i] 与 nums[j]之间没有重复项
 * nums[j] 赋值给 nums[i+1]， j++ 对下一个值做判断。从第一项至 i 项，仍然没有重复项。
 * <p>
 * 直到最后一项，此时，从 0 到 下标i指向的是最新的生成的没有重复项的数组。 数组长度为 i+1
 * <p>
 * 2 注意边界条件的判断，eg: 数组为空该怎么处理？
 */

import java.util.Arrays;

/**
 * 2021年12月20日23:26:14
 * <p>
 * https://leetcode-cn.com/problems/move-zeroes/
 * <p>
 * 移动 0
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 解法：
 * 1 双指针法
 * 2 两次循环发
 * 3 双指针 优化法
 */
public class MoveZero {

    public static void main(String[] args) {

        int[] ints = new int[]{0, 5, 6, 0, 1, 0, 3, 12};
//        moveZeroBy1For(ints);
//        moveZeroBy2For(ints);
//        moveZeroBy1ForImp(ints);
//
//        moveZeroBy1ForRepeat1(ints);
//        moveZeroBy2ForRepeat1(ints);
//        moveZeroBy1ForImpRepeat1(ints);
//
//        moveZeroBy1ForRepeat2(ints);
//        moveZeroBy1ForImpRepeat2(ints);
        moveZeroBy2ForRepeat2(ints);

//        moveZeroBy1ForRepeat3(ints);

        move0For1Repeat3(new int[]{0, 5, 6, 0, 1, 0, 3, 12});
        move0For2Repeat3(new int[]{0, 5, 6, 0, 1, 0, 3, 12});
        move0For1Repeat4(new int[]{0, 5, 6, 0, 1, 0, 3, 12});
        move0For2Repeat4(new int[]{0, 5, 6, 0, 1, 0, 3, 12});
    }

    private static void move0For2Repeat4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    // 一次 for 循环 移动 0
    private static void move0For1Repeat4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int j = 0, temp = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                if (i != j) {
                    temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    // 两次 for 循环， 第三遍
    private static void move0For2Repeat3(int[] arrays) {

        if (arrays == null) {
            return;
        }

        int j = 0;
        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i] != 0) {
                arrays[j++] = arrays[i];
            }
        }

        for (int i = j; i < arrays.length; i++) {
            arrays[i] = 0;
        }

        System.out.println(Arrays.toString(arrays));

    }

    // 一次for循环， 第三遍
    private static void move0For1Repeat3(int[] arrays) {

        if (arrays == null) {
            return;
        }

        // 记录需要指向 值为 0  的index
        int j = 0, temp = 0;

        for (int i = 0; i < arrays.length; i++) {

            if (arrays[i] != 0) {

                if (i != j) {
                    temp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = temp;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(arrays));
    }


    // 一次for循环移动 0 ，第三遍

    private static void moveZeroBy1ForRepeat3(int[] ints) {

        if (ints == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < ints.length; i++) {

            if (ints[i] != 0) {
                if (i != j) {
                    int temp = ints[i];
                    ints[i] = ints[j];
                    ints[j] = temp;
                }
                j++;
            }


        }
        System.out.println(Arrays.toString(ints));
    }

    private static void moveZeroBy2ForRepeat2(int[] nums) {
        // 交换 -> 两次赋值
        if (nums == null) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }

        for (int i = j; i < nums.length; i++) {
            nums[i] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeroBy1ForImpRepeat2(int[] nums) {
        if (nums == null) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                if (j < i) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));

    }

    private static void moveZeroBy1ForRepeat2(int[] nums) {
        if (nums == null) {
            return;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));

    }

    private static void moveZeroBy1ForImpRepeat1(int[] ints) {

        if (ints == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                if (j < i) {
                    ints[j] = ints[i];
                    ints[i] = 0;
                }
                j++;
            }
        }
        System.out.println(Arrays.toString(ints));
    }

    //
    private static void moveZeroBy2ForRepeat1(int[] ints) {

        if (ints == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                ints[j++] = ints[i];
            }
        }
        for (int i = j; i < ints.length; i++) {
            ints[i] = ints[j];
        }
        System.out.println(Arrays.toString(ints));
    }

    private static void moveZeroBy1ForImp(int[] ints) {
        if (ints == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                if (i > j) {
                    ints[j] = ints[i];
                    ints[i] = 0;
                }
                j++;
            }
        }
    }

    private static void moveZeroBy1ForRepeat1(int[] ints) {
        if (ints == null) {
            return;
        }
        int j = 0;
        for (int i = 0; i < ints.length; i++) {

            if (ints[i] != 0) {
                int temp = ints[i];
                ints[i] = ints[j];
                ints[j++] = temp;
            }
        }

        System.out.println(Arrays.toString(ints));
    }

    /**
     * 一次 for 循环，采用的是快速排序的思想
     *
     * @param array
     * @return
     */
    private static int[] moveZeroBy1For(int[] array) {
        if (array == null || array.length == 0) {
            return new int[0];
        }

        // 右边一直移动的指针
        int point0 = 0;
        for (int i = 0; i < array.length; i++) {

            if (array[i] != 0) {

                int temp = array[i];
                array[i] = array[point0];
                array[point0++] = temp;
            }
        }

        System.out.println(Arrays.toString(array));
        return array;
    }

    /**
     * 2次 for 循环， 一次移动非0，一次补充0
     *
     * @param ints
     */
    private static void moveZeroBy2For(int[] ints) {

        if (ints == null || ints.length == 0) {
            return;
        }

        int j = 0;
        for (int i = 0; i < ints.length; i++) {

            if (ints[i] != 0) {
                ints[j++] = ints[i];
            }
        }

        for (int i = j; i < ints.length; i++) {
            ints[i] = 0;
        }

        System.out.println(Arrays.toString(ints));
    }

    // 左右夹逼法
    private static int removeElement(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while (left < right) {

            if (nums[left] == target) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }

        return left;

    }

    // 都从左边出发
    private static int removeElement1_2(int[] nums, int target) {

        if (nums == null) {
            return -1;
        }

        int j = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return j;

    }

    // 左右夹逼法
    private static int removeElement2_2(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while (left < right) {
            if (nums[left] == target) {
                nums[left] = nums[right--];
            } else {
                left++;
            }
        }
        return left;
    }
}
