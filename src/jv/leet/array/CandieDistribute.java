package jv.leet.array;


public class CandieDistribute {

    public static void main(String[] args) {

    }


    public static int[] distribute2(int candies, int count) {


        if (candies <= 0 || count <= 0) {
            return new int[0];
        }

        int[] result = new int[count];

        int currentItemCount = 0;

        while (candies > 0) {
            result[currentItemCount % count] += Math.min(currentItemCount + 1, candies);

            candies -= Math.min(currentItemCount + 1, candies);
            currentItemCount++;
        }

        return result;

    }

    public static int[] distribute(int candies, int count) {

        if (candies <= 0 || count <= 0) {
            return new int[0];
        }

        int[] result = new int[count];

        int times = 0;

        while (candies > 0) {

            for (int i = 0; i < count; i++) {
                int needItem = times * count + i + 1;

                if (candies > needItem) {

                    result[i] += needItem;
                    candies -= result[i];
                } else {

                    result[i] += candies;
                    candies = 0;
                    break;
                }
            }

            times++;
        }


        return result;
    }

    public static int[] distribute1_3(int candies, int count) {

        if (candies <= 0 || count <= 0) {
            return null;
        }

        int[] result = new int[count];

        int times = 0;

        while (candies > 0) {

            for (int i = 0; i < count; i++) {

                int defaultCount = times * count + i + 1;

                if (candies > defaultCount) {

                    result[i] += defaultCount;
                    candies -= defaultCount;

                } else {
                    result[i] += candies;
                    candies = 0;
                    break;
                }
            }

            times++;

        }
        return result;
    }

    public static int[] distribute2_3(int candies, int childCount) {

        if (candies <= 0 || childCount <= 0) {
            return null;
        }

        int totalCount = 0;
        int[] result = new int[childCount];

        while (candies > 0) {

            result[totalCount % childCount] += Math.min(totalCount + 1, candies);
            candies -= Math.min(totalCount + 1, candies);

            totalCount++;
        }

        return result;
    }
}
