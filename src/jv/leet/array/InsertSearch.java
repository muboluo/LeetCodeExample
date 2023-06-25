package jv.leet.array;

/**
 * 插值查找原理介绍
 * <p>
 * https://blog.csdn.net/qq_44236958/article/details/110949481
 * 插值查找法类似于二分查找法,不同的是插值查找每次从自适应mid处开始查找
 * <p>
 * 将折半查找中的求 mid索引的公式,low表示左边索引left,high表示右边索引right
 * <p>
 * key就是需要查找到元素
 */
public class InsertSearch {

    public static void main(String[] args) {

    }

    // 最主要的区别就是，middle 的计算方式。其他都一样。
    public static int insertValue(int[] arr, int left, int right, int findVal) {
        if (left > right || findVal < arr[0] || findVal > arr[arr.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (findVal - arr[left]) / (arr[right] - arr[left]);
        int midVAl = arr[mid];
        if (findVal > midVAl) {
            return insertValue(arr, mid + 1, right, findVal);
        } else if (findVal < midVAl) {
            return insertValue(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    public static int insert(int[] nums, int left, int right, int finalVal) {

        if (nums == null || finalVal < nums[left] || finalVal > nums[right] || left > right) {
            return -1;
        }

        int middle = left + (right - left) * (finalVal - nums[left]) / (nums[right] - nums[left]);

        if (nums[middle] == finalVal) {
            return middle;
        } else if (nums[middle] < finalVal) {
            return insertValue(nums, middle, right, finalVal);
        } else {
            return insertValue(nums, left, middle, finalVal);
        }
    }

}
