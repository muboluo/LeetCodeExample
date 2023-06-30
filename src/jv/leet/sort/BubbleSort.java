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
}
