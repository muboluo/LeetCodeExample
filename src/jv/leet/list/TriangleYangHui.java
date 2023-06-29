package jv.leet.list;

import java.util.ArrayList;
import java.util.List;

// 杨辉三角
public class TriangleYangHui {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> generate2(int numRows) {

        if (numRows <= 0) {
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> currentList = new ArrayList<>();

            for (int j = 0; j <= i; j++) {

                if (j == 0 || j == i) {
                    currentList.add(1);
                } else {
                    currentList.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(currentList);
        }
        return result;
    }

    public static List<List<Integer>> generate(int numRows) {


        if (numRows <= 0) {
            return new ArrayList<>(0);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {

            List<Integer> currentList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    currentList.add(1);
                } else {
                    currentList.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(currentList);
        }
        return result;
    }
}
