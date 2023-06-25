package jv.leet.array;

//二分查找

/**
 * https://blog.csdn.net/qq_44236958/article/details/110949481
 */
public class BinaryTwoSearch {

    /**
     * 非递归 二分法
     *
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

}
