package jv.leet.sort;

import java.util.Arrays;

// 归并排序
// 使用了 递归 和 额外空间的方式。
public class Merge {

    public static void main(String[] args) {

    }

    private static int[] mergeSort(int[] nums) {

        if (nums == null || nums.length < 2) {
            return nums;
        }

        int middle = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, middle);
        int[] right = Arrays.copyOfRange(nums, middle, nums.length);

        return merge(mergeSort(left), mergeSort(right));

    }

    private static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int index = 0;
        while (index < result.length) {

            if (index > leftIndex) {
                result[index++] = right[rightIndex++];
            } else if (index > rightIndex) {
                result[index++] = right[leftIndex++];
            } else if (left[leftIndex] <= right[rightIndex]) {
                result[index++] = left[leftIndex++];
            } else {
                result[index++] = left[rightIndex++];
            }
        }
        return result;
    }
}
