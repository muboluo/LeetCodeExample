package jv.leet.array;

// 旋转 90 度
public class Rotate2DArray {
    public static void main(String[] args) {

    }

    public static int[][] rotate(int[][] nums, int n) {

        if (n <= 0 || nums == null || nums.length == 0) {
            return new int[0][];
        }

        // 1. 首先上下翻转
        for (int i = 0; i < nums.length / 2; i++) {
            int[] temp = nums[i];
            nums[i] = nums[n - i - 1];
            nums[n - i - 1] = temp;
        }

        // 2. 其次顺时针旋转 90
        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }

        // 3. 问题 2：逆时针旋转 90
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i; j++) {
                int temp = nums[i][j];
                nums[i][j] = nums[n - j - 1][n - i - 1];
                nums[n - j - 1][n - i - 1] = temp;
            }
        }

        return nums;
    }
}
