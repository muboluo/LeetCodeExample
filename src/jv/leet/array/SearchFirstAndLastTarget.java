package jv.leet.array;

// 找到 有序数组中，第一个和最后一个元素所在的位置，并进行输出。
public class SearchFirstAndLastTarget {

    public static void main(String[] args) {

    }

    private static int[] find(int[] nums, int target) {

        int[] result = new int[]{-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }

        result[0] = extracted(true, nums, target);
        result[1] = extracted(false, nums, target);


        return result;
    }

    private static int extracted(boolean isFirst, int[] nums, int target) {
        // 定义临时变量
        int start = 0, end = nums.length - 1;

        while (start <= end) {

            int middle = start + (end - start) / 2;
            if (target > nums[middle]) {

                start = middle + 1;
            } else if (target < nums[middle]) {
                end = middle - 1;
            } else {
                if (isFirst) {
                    if (middle > 0 && nums[middle] == nums[middle - 1]) {
                        end = middle - 1;
                    } else {
                        return middle;
                    }
                } else {
                    if (middle < nums.length - 1 && nums[middle] == nums[middle + 1]) {
                        start = middle + 1;
                    } else {
                        return middle;
                    }
                }

            }
        }
        return -1;
    }


    private static int[] find2(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int[] result = new int[]{-1, -1};

        result[0] = extracted2(true, nums, target);
        result[1] = extracted2(false, nums, target);
        return result;
    }

    private static int extracted2(boolean isFirst, int[] nums, int target) {

        int left = 0, right = nums.length;
        int middleIndex = 0;

        while (left < right) {

            middleIndex = (left + right) / 2;

            if (nums[middleIndex] > target) {
                left = middleIndex + 1;
            } else if (nums[middleIndex] < target) {
                right = middleIndex - 1;
            } else {

                if (isFirst) {

                    if (middleIndex > 0 && nums[middleIndex] == nums[middleIndex - 1]) {
                        right = middleIndex - 1;
                    } else {
                        return middleIndex;
                    }

                } else {

                    if (middleIndex < nums.length - 1 && nums[middleIndex] == nums[middleIndex + 1]) {
                        left = middleIndex + 1;
                    } else {
                        return middleIndex;
                    }

                }
            }

        }

        return -1;
    }
}
