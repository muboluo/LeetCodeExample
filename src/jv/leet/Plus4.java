package jv.leet;

import java.util.HashMap;

class Plus4 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {

        HashMap<Integer, Integer> sumMap = new HashMap();
        int sum = 0;
        for (int i = 0; i < A.length; ++i) {
            for (int j = 0; j < B.length; ++j) {

                sum = A[i] + B[j];

                if (sumMap.containsKey(sum)) {
                    sumMap.put(sum, sumMap.get(sum) + 1);
                } else {
                    sumMap.put(sum, 1);
                }
            }
        }

        int sum2 = 0;
        int count = 0;
        for (int i = 0; i < C.length; ++i) {
            for (int j = 0; j < D.length; ++j) {

                sum2 = -C[i] - D[j];
                if (sumMap.containsKey(sum2)) {
                    count += sumMap.get(sum2);
                }
            }
        }
        return count;

    }

}
