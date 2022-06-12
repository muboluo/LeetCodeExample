package jv.leet.array;

import java.util.Arrays;


/**
 * 删除有序数组中的重复项
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/solution/shuang-zhi-zhen-shan-chu-zhong-fu-xiang-dai-you-hu/
 * <p>
 * 步骤：
 */
public class DeleteRepeatInOrderedArray {


    public static int deleteRepeat(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }
        int slow = 0, fast = 1;

        while (fast < array.length) {

            // 只有当 [slow] != [fast] 时， 🌈 才可以更新下一个值。
            if (array[slow] != array[fast]) {
                array[slow + 1] = array[fast];
                slow++;
            }
            fast++;
        }
        System.out.println(Arrays.toString(array));
        return slow;
    }

    public static int deleteRepeat2(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int slow = 0, fast = 1;
        while (fast < array.length) {

            if (array[slow] != array[fast]) {
                array[++slow] = array[fast];
            }

            fast++;
        }
        System.out.println(Arrays.toString(array));
        return slow;
    }

    public static int deleteRepeat3(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int fast = 1, slow = 0;
        while (fast < array.length) {

            if (array[slow] != array[fast]) {
                array[++slow] = array[fast];
            }
            fast++;
        }

        System.out.println(Arrays.toString(array));
        return slow;

    }

    private static int deleteRepeat4(int[] nums) {

        if (nums == null || nums.length == 0) {
            return -1;
        }

        int slow = 0, fast = 1;
        while (fast < nums.length) {

            if (nums[fast] != nums[slow]) {
                nums[slow + 1] = nums[fast];
                slow++;
            }
            fast++;
        }

        for (int i = slow + 1; i < nums.length; i++) {
            nums[i] = 0;
        }

        System.out.println(Arrays.toString(nums));
        return slow;

    }

    public static void main(String[] args) {

        deleteRepeat(new int[]{0, 1, 2, 3, 4, 5, 5, 5, 6, 7, 7, 9});
        deleteRepeat2(new int[]{0, 1, 2, 3, 4, 5, 5, 5, 6, 7, 7, 9});
        deleteRepeat3(new int[]{0, 1, 2, 3, 4, 5, 5, 5, 6, 7, 7, 9});
        deleteRepeat4(new int[]{0, 1, 2, 3, 4, 5, 5, 5, 6, 7, 7, 9});

    }

}
