package jv.leet.array;

// 螺旋遍历
public class SpiralTraversal {

    public static void main(String[] args) {

    }

    public static int[][] generateMatrix(int number) {

        if (number <= 0) {
            return new int[0][];
        }

        int[][] result = new int[number][number];

        int i1 = 0, i2 = number - 1, j1 = 0, j2 = number - 1;

        int item = 1;
        // set clause
        while (i1 < i2 && j1 < j2) {

            // top
            for (int j = j1; j < j2; j++) {
                result[i1][j] = item++;
            }

            // right
            for (int i = i1 ; i < i2; i++) {
                result[i][j2] = item++;
            }

            // bottom
            for (int j = j2; j > j1; j--) {
                result[i2][j] = item++;
            }

            // left
            for (int i = i2; i > i1; i--) {
                result[i][j2] = item++;
            }

            // jump next level
            i1++;
            i2--;
            j1++;
            j2--;
        }

        return result;
    }
}
