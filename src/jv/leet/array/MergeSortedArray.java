package jv.leet.array;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/
 * <p>
 * 合并两个有序数组到第一个数组中。
 * <p>
 * 三种方法：
 * <p></p>
 * 1. 暴力破解法 ， 快排法  时间(m+n)log(m+n) ，空间复杂度 都是 log(m+n)
 * <p></p>
 * 2. 正向 双指针法 时间/空间 复杂度 都是 (m + n)
 * <p></p>
 * 3. 反向 双指针法 时间 (m+n) 空间复杂度 1
 */
public class MergeSortedArray {

    public static void main(String[] args) {

    }

    // 快速排序1
    public static void merge11(int[] array1, int validLength1, int[] array2, int validLength2) {

        for (int i = 0; i < validLength2; i++) {

            array1[i + validLength1] = array2[i];
        }
        Arrays.sort(array1);
    }

    // 快速排序2 时间复杂度(m+n)log(m+n), 空间 log(m+n)
    public static void merge12(int[] array1, int validLength1, int[] array2, int validLength2) {

        for (int i = 0; i < validLength2; i++) {
            array1[i + validLength1] = array2[i];
        }

        Arrays.sort(array1);
    }

    // 快速排序3 时间复杂度 （m+n)log(m+n)  空间 log (m+n)
    public static void merge13(int[] array1, int validLength1, int[] array2, int validLength2) {

        for (int i = 0; i < validLength2; i++) {
            array1[i + validLength1] = array2[i];
        }
        Arrays.sort(array1);
    }

    // 正向 双指针 时间/空间 m+n
    public static void merge21(int[] array1, int validLength1, int[] array2, int validLength2) {

        int[] sorted = new int[validLength1 + validLength2];

        int i1 = 0, i2 = 0;

        int cur;

        while (i1 < validLength1 || i2 < validLength2) {


            if (i1 >= validLength1) {
                cur = array2[i2++];
            } else if (i2 >= validLength2) {
                cur = array1[i1++];
            } else if (array1[i1] < array2[i2]) {
                cur = array1[i1++];
            } else {
                cur = array2[i2++];
            }

            sorted[i1 + i2 - 1] = cur;
        }

        for (int i = 0; i < validLength1 + validLength2; i++) {
            array1[i] = sorted[i];
        }

    }

    // 正向双指针法 2  m+n
    public static void merge22(int[] array1, int validLength1, int[] array2, int validLength2) {

        int i1 = 0, i2 = 0;
        int[] sorted = new int[validLength1 + validLength2];

        int cur;
        while (i1 < validLength1 || i2 < validLength2) {

            if (i1 >= validLength1) {
                cur = array2[i2++];
            } else if (i2 >= validLength2) {
                cur = array1[i1++];
            } else if (array1[i1] < array2[i2]) {
                cur = array1[i1++];
            } else {
                cur = array2[i2++];
            }

            sorted[i1 + i2 - 1] = cur;
        }

        for (int i = 0; i < sorted.length; i++) {
            array1[i] = sorted[i];
        }
    }

    // 正向双指针法 3
    public static void merge23(int[] array1, int validLength1, int[] array2, int validLength2) {

        int[] sorted = new int[validLength1 + validLength2];
        int i1 = 0, i2 = 0;
        int cur;

        while (i1 < validLength1 || i2 < validLength2) {

            if (i1 >= validLength1) {
                cur = array2[i2++];
            } else if (i2 >= validLength2) {
                cur = array1[i1++];
            } else if (array1[i1] < array2[i2]) {
                cur = array1[i1++];
            } else {
                cur = array2[i2++];
            }

            sorted[i1 + i2 - 1] = cur;
        }

        for (int i = 0; i < sorted.length; i++) {
            array1[i] = sorted[i];
        }
    }

    // 反向 双指针法
    public static void merge31(int[] array1, int validLength1, int[] array2, int validLength2) {

        int tail = validLength1 + validLength2 - 1;

        int i1 = validLength1 - 1;
        int i2 = validLength2 - 1;

        int cur;
        while (i1 >= 0 || i2 >= 0) {

            if (i1 < 0) {
                cur = array2[i2--];
            } else if (i2 < 0) {
                cur = array1[i1--];
            } else if (array1[i1] < array2[i2]) {
                cur = array1[i1--];
            } else {
                cur = array2[i2--];
            }

            array1[tail--] = cur;
        }

    }

    // 反向 双指针法 时间 m + n , 空间 1
    public static void merge32(int[] array1, int validLength1, int[] array2, int validLength2) {

        int i1 = validLength1 - 1;
        int i2 = validLength2 - 1;

        int tail = validLength1 + validLength2 - 1;

        int cur;

        while (i1 >= 0 || i2 >= 0) {

            if (i1 < 0) {
                cur = array2[i2--];
            } else if (i2 < 0) {
                cur = array1[i1--];
            } else if (array1[i1] < array2[i2]) {
                cur = array1[i1--];
            } else {
                cur = array2[i2--];
            }

            array1[tail--] = cur;
        }

    }

    // 逆向 双指针法， 时间 m+n , 空间 1
    public static void merge33(int[] array1, int validLength1, int[] array2, int validLength2) {

        int i1 = validLength1 - 1, i2 = validLength2 - 1;

        int tail = validLength1 + validLength2 - 1;

        int cur;

        while (i1 >= 0 || i2 >= 0) {

            if (i1 < 0) {
                cur = array2[i2--];
            } else if (i2 < 0) {
                cur = array1[i1--];
            } else if (array1[i1] < array2[i2]) {
                cur = array1[i1--];
            } else {
                cur = array2[i2--];
            }
            array1[tail--] = cur;
        }
    }


}
