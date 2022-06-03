package jv.leet.array;

import java.util.Arrays;

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
        return 0;
    }

    public static void main(String[] args) {

        deleteRepeat(new int[]{0, 1, 2, 3, 4, 5, 5, 5, 6, 7, 7, 9});
        deleteRepeat2(new int[]{0, 1, 2, 3, 4, 5, 5, 5, 6, 7, 7, 9});

    }
}
