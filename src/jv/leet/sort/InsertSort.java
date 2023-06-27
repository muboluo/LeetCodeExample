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
}
