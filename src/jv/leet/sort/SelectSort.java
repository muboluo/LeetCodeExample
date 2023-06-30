package jv.leet.sort;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {


    }

    public static int[] sort(int nums[]) {

        if (nums == null || nums.length == 0) {
            return nums;
        }

        // 从当前位置开始，对比之后所有的item，选择最小的，互换 item
        for (int i = 0; i < nums.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = nums[minIndex];
                nums[minIndex] = nums[i];
                nums[i] = temp;
            }
        }

        return nums;
    }
}
