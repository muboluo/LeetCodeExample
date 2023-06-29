package jv.leet.array;

// 搜索插入值的位置
public class SearchInsertPosition {

    public static void main(String[] args) {

    }

    public static int insertPos(int[] numbers, int target) {

        if (numbers == null || numbers.length == 0) {
            return -1;
        }

        // init temp
        int left = 0, right = numbers.length - 1;

        // for each
        while (left < right) {

            int middle = left + (right - left) * (target - numbers[left]) / (numbers[right] - numbers[left]);
            if (target < numbers[middle]) {
                right = middle - 1;
            } else if (target > numbers[middle]) {
                // 为了能在算法进入到最后几步时，继续向前走。这里需要加一。
                left = middle + 1;
            } else {
                return middle;
            }
        }

        // jump next level

        return left;
    }

    public static int insertPos2(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int left = 0, right = nums.length - 1;

        int middle = 0;
        while (left < right) {

            middle = (left + right) / 2;

            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                right = nums[middle - 1];
            } else {

                left = nums[middle + 1];
            }
        }

        return left;


    }
}
