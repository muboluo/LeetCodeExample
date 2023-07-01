package jv.leet.sort;

// 堆排序

import sun.security.util.Length;

import java.util.Arrays;

/**
 * https://www.runoob.com/w3cnote/heap-sort.html
 * <p>
 * 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。堆排序可以说是一种利用堆的概念来排序的选择排序。分为两种方法：
 * <p>
 * 大顶堆：每个节点的值都大于或等于其子节点的值，在堆排序算法中用于升序排列；
 * 小顶堆：每个节点的值都小于或等于其子节点的值，在堆排序算法中用于降序排列；
 * 堆排序的平均时间复杂度为 Ο(nlogn)。
 * <p>
 * 1. 算法步骤
 * 创建一个堆 H[0……n-1]；
 * <p>
 * 把堆首（最大值）和堆尾互换；
 * <p>
 * 把堆的尺寸缩小 1，并调用 shift_down(0)，目的是把新的数组顶端数据调整到相应位置；
 * <p>
 * 重复步骤 2，直到堆的尺寸为 1。
 */
public class HeapSort {

    public static void main(String[] args) {

    }

    // 程序入口
    // 构建 max on top 的 堆
    // 从 n/2 开始，逐步递减进行查找。
    //      涉及到了递归
    //
    private static int[] sort(int[] nums) {

        if (nums == null || nums.length < 2) {
            return nums;
        }

        int[] result = Arrays.copyOf(nums, nums.length);

        int len = result.length;

        // 创建最大数在最顶部的堆
        buildMaxHeap(result, len);

        // 创建完成之后，只是最大值是有序的，还需要调整底部的顺序。
        for (int i = len - 1; i > 0; i--) {

            swap(nums, 0, i);
            len--;
            heapify(nums, 0, len);
        }

        return result;
    }

    // 创建最大数在最顶部的堆
    private static void buildMaxHeap(int[] nums, int len) {

        for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
            heapify(nums, i, len);
        }
    }

    private static void heapify(int[] nums, int i, int len) {
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largestIndex = i;

        if (left < len && nums[left] > nums[largestIndex]) {
            largestIndex = left;
        }
        if (right < len && nums[right] > nums[largestIndex]) {
            largestIndex = right;
        }
        if (largestIndex != i) {
            swap(nums, i, largestIndex);
            // 更新最大数的坐标之后，查找 以该坐标为 top 的所有子项的 最大数
            heapify(nums, largestIndex, len);
        }
    }

    private static void swap(int[] nums, int i, int largestIndex) {

        int temp = nums[i];
        nums[i] = nums[largestIndex];
        nums[largestIndex] = temp;
    }


    private int[] sort2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        // 是否改变原数组

        // build Max on Top heap
        int len = nums.length;
        buildMaxOnTopHeap(nums, len);

        // change top ,rebuild max on top
        for (int i = len - 1; i > 0; i--) {

            swap(nums, i, 0);
            len--;
            heapify2(nums, 0, len);
        }

        return nums;
    }

    private void buildMaxOnTopHeap(int[] nums, int len) {
        if (nums == null) {
            return;
        }

        for (int i = nums.length / 2; i >= 0; i--) {
            heapify2(nums, i, len);
        }
    }

    private void heapify2(int[] nums, int i, int len) {

        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;
        int maxIndex = i;

        if (leftIndex < len && nums[leftIndex] > nums[maxIndex]) {
            maxIndex = leftIndex;
        }

        if (rightIndex < len && nums[rightIndex] > nums[maxIndex]) {
            maxIndex = rightIndex;
        }

        if (maxIndex != i) {
            swap(nums, maxIndex, i);
            heapify2(nums, maxIndex, len);
        }

    }


    private int[] sort3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] array = Arrays.copyOf(nums, nums.length);

        int len = nums.length;

        buildMaxOnTop3(array, len);

        //倒序
        for (int i = len - 1; i > 0; i--) {
            swap3(array, i, 0);
            len--;
            heapify3(array, i, len);
        }

        return array;
    }

    private static void buildMaxOnTop3(int[] array, int len) {

        for (int i = len / 2; i >= 0; i--) {
            heapify3(array, i, len);
        }
    }

    private static void heapify3(int[] array, int i, int len) {

        int leftIndex = i * 2 + 1;
        int rightIndex = i * 2 + 2;
        int maxIndex = i;

        if (array[leftIndex] < array[i] && leftIndex < len) {
            maxIndex = leftIndex;
        }

        if (array[rightIndex] < array[i] && rightIndex < len) {
            maxIndex = rightIndex;
        }

        if (maxIndex != i) {
            swap3(array, maxIndex, i);
            heapify3(array, maxIndex, len);
        }
    }

    private static void swap3(int[] array, int a, int b) {

        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;

    }
}
