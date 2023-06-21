package jv.leet.array;

// 颜色分类
public class ColorSeparate {

    public static void main(String[] args) {

    }

    public static int[] separate(int[] colors) {

        if (colors == null || colors.length == 0) {
            return new int[0];
        }

        int l = 0;

        for (int i = 0; i < colors.length; i++) {

            if (colors[i] == 0) {
                colors[l] = colors[i];
                colors[i] = 0;
                l++;
            }
        }
        for (int i = l; i < colors.length; i++) {

            if (colors[i] == 1) {
                colors[l] = colors[i];
                colors[i] = 1;
                l++;
            }
        }

        return colors;
    }


    // 荷兰国旗问题
    public static int[] separate2(int[] colors) {

        if (colors == null || colors.length == 0) {
            return new int[0];
        }

        int left = 0, cur = 0, right = colors.length - 1;

        while (left < right) {

            if (colors[cur] == 0) {
                colors[cur] = colors[left];
                colors[left] = 0;
                left++;
                cur++;
            } else if (colors[cur] == 2) {
                colors[cur] = colors[right];
                colors[right] = 0;
                right--;
            } else {
                cur++;
            }

        }

        return colors;

    }
}
