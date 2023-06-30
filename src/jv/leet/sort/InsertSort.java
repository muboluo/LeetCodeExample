package jv.leet.sort;

public class InsertSort {

    public static int[] insertSort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        // 确定 和 不确定： 在两数相等时，是否移动。
        // 本遍历属于确定类型的，不移动两数相等的情况。
        for (int i = 0; i < array.length - 1; i++) {
            int current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }

        return array;
    }

    public static int[] insertSort2(int[] array) {

        if (array == null || array.length == 0) {
            return new int[0];
        }

        // 判断是否改变原始数据
        for (int i = 0; i < array.length - 1; i++) {

            int cur = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && array[preIndex] > cur) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }

            array[preIndex + 1] = cur;
        }
        return array;
    }

    // currentItem 和他之前所有的对比，找到第一个比他小的 item 的 index 为止。
    // 将 currentItem 的值，赋值给比他小的 item 的后面一项。
    private static int[] sort3(int[] nums) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        for (int i = 0; i < nums.length - 1; i++) {

            int currentItem = nums[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && currentItem < nums[preIndex]) {
                nums[preIndex + 1] = nums[preIndex];
                preIndex--;
            }
            nums[preIndex + 1] = currentItem;
        }

        return nums;
    }
}
