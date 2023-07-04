package jv.leet.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {

    }

    private static int[] bubbleSort(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length - 1 - i; j++) {

                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        return nums;

    }

    // 关键点
    // 1. 比较相邻 index 的大小。
    private static int[] bubbleSort2(int[] nums) {

        if (nums == null) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length - i - 1; j++) {

                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return nums;
    }
}
