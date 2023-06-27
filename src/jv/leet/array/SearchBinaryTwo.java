package jv.leet.array;

//二分查找

/**
 * https://blog.csdn.net/qq_44236958/article/details/110949481
 */
public class SearchBinaryTwo {

    /**
     * 非递归 二分法
     */
    private static int binary(int[] nums, int finalVal) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        int middle;

        while (left <= right) {

            middle = (left + right) / 2;

            if (nums[middle] == finalVal) {
                return middle;
            } else if (nums[middle] < finalVal) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    private static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {

            int middleIndex = (right + left) / 2;

            if (nums[middleIndex] == target) {
                return middleIndex;
            } else if (nums[middleIndex] < target) {
                left = middleIndex + 1;
            } else {
                right = middleIndex - 1;
            }

        }

        return -1;
    }

}
