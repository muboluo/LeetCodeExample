package jv.leet.array;

import java.util.Arrays;

/**
 * 根据第 K 个旋转数组
 * <p>
 * https://leetcode.cn/problems/rotate-array/
 * <p>
 * 数组元素，向右轮转 k 个位置， 其中 K 是非负数
 * <p>
 * 扩展： 向右轮转 k 个位置。
 * <p>
 * 实现1：使用额外空间，存储变量
 * <p>
 * 实现2：翻转数组法
 * <p>
 * 先整个列表翻转，然后再以k为分界，分成两个部分。单独进行翻转。
 */
public class RotateArrayByIndexK {

    public static void rotate11(int[] nums, int k) {

        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
        System.out.println(Arrays.toString(nums));

    }

    public static void rotate12(int[] array, int k) {

        int n = array.length;
        int[] newArray = new int[n];
        for (int i = 0; i < n; i++) {
            newArray[(i + k) % n] = array[i];
        }

        System.arraycopy(newArray, 0, array, 0, n);
        System.out.println(Arrays.toString(array));
    }

    public static void rotate21(int[] array, int k) {

        if (array == null || array.length == 0) {
            return;
        }

        int length = array.length;
        reverse21(array, 0, length - 1);
        reverse21(array, 0, k - 1);
        reverse21(array, k, length - 1);

        System.out.println(Arrays.toString(array));
    }

    public static void reverse21(int[] array, int start, int end) {

        while (start < end) {

            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate22(int[] array, int k) {

        int length = array.length;
        reverse22(array, 0, length - 1);
        reverse22(array, 0, k - 1);
        reverse22(array, k, length - 1);

        System.out.println(Arrays.toString(array));
    }

    private static void reverse22(int[] array, int start, int end) {

        if (array == null) {
            return;
        }

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }


    public static void main(String[] args) {

        rotate11(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 4);
        rotate12(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 4);
        rotate13(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 4);
        rotate21(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 4);
        rotate22(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 4);
        rotate23(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11}, 4);
    }

    private static void rotate13(int[] ints, int k) {

        if (ints == null || ints.length <= 0 || ints.length < k) {
            return;
        }

        int[] newInts = new int[ints.length];

        for (int i = 0; i < ints.length; i++) {
            newInts[(i + k) % ints.length] = ints[i];
        }

        System.arraycopy(newInts, 0, ints, 0, ints.length);
        System.out.println(Arrays.toString(ints));
    }

    private static void rotate23(int[] nums, int k) {

        if (nums == null || nums.length <= 0 || nums.length < k) {
            return;

        }

        reverse23(0, nums.length - 1, nums);
        reverse23(0, k - 1, nums);
        reverse23(k, nums.length - 1, nums);

        System.out.println(Arrays.toString(nums));
    }

    private static void reverse23(int start, int end, int[] nums) {

        if (nums == null || nums.length <= 0) {
            return;
        }

        while (start < end) {

            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }


    }
}

