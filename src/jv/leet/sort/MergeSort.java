package jv.leet.sort;

import java.util.Arrays;

// 归并排序
// 使用了 递归 和 额外空间的方式。
public class MergeSort {

    public static void main(String[] args) {

    }

    private static int[] mergeSort2(int[] nums) {

        if (nums == null || nums.length < 2) {
            return nums;
        }

        int middle = nums.length/2;

        int[] left = Arrays.copyOfRange(nums, 0, middle);
        int[] right = Arrays.copyOfRange(nums,  middle, nums.length);

        return merge2(mergeSort2(left), mergeSort2(right));
    }

    private static int[] merge2(int[] left, int[] right) {

        // 需要判空
        int leftLen = left == null? 0: left.length;
        int rightLen = right == null? 0: right.length;

        int[] result = new int[leftLen + rightLen];
        int resultIndex = 0, leftIndex = 0, rightIndex = 0;

        while (leftIndex < leftLen || rightIndex < rightLen) {

            if (leftIndex >= leftLen) {
                result[resultIndex++] = right[rightIndex++];
            } else if (rightIndex >= rightLen) {
                result[resultIndex++] = right[leftIndex++];
            } else if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }
        return result;
    }
}
