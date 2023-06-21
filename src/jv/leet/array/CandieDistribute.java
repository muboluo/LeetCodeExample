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
}
