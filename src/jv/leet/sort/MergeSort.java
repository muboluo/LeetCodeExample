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

        int middle = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, middle);
        int[] right = Arrays.copyOfRange(nums, middle, nums.length);

        return merge2(mergeSort2(left), mergeSort2(right));
    }

    private static int[] merge2(int[] left, int[] right) {

        // 需要判空
        int leftLen = left == null ? 0 : left.length;
        int rightLen = right == null ? 0 : right.length;

        int[] result = new int[leftLen + rightLen];
        int resultIndex = 0, leftIndex = 0, rightIndex = 0;

        while (leftIndex < leftLen || rightIndex < rightLen) {

            if (leftIndex >= leftLen) {
                result[resultIndex++] = right[rightIndex++];
            } else if (rightIndex >= rightLen) {
                result[resultIndex++] = left[leftIndex++];
            } else if (left[leftIndex] < right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }
        return result;
    }

    // 先 分组 sort ，再 逐步 merge
    private static int[] sort3(int[] nums) {

        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        // 拆分数组，好方便后续使用数组的长度

        int middleIndex = nums.length / 2;

        int[] left = Arrays.copyOfRange(nums, 0, middleIndex);
        int[] right = Arrays.copyOfRange(nums, middleIndex, nums.length);

        return merge3(sort3(left), sort3(right));

    }

    private static int[] merge3(int[] left, int[] right) {

        int leftLen = left == null ? 0 : left.length;
        int rightLen = right == null ? 0 : right.length;

        int[] result = new int[leftLen + rightLen];

        int leftCur = 0, rightCur = 0, resultCur = 0;

        while (leftCur < leftLen || rightCur < rightLen) {

            if (leftCur >= leftLen) {
                result[resultCur++] = right[rightCur++];
            } else if (rightCur >= rightLen) {
                result[resultCur++] = left[leftCur++];
            } else if (left[leftCur] <= right[rightCur]) {
                result[resultCur++] = left[leftCur++];
            } else {
                result[resultCur++] = right[rightCur++];
            }
        }
        return result;
    }
}
