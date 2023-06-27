package jv.leet.sort;

public class Shell {

    public static void main(String[] args) {

    }

    private int[] shellSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }

        int len = nums.length;
        int cur, gap = len / 2;

        while (gap > 0) {

            //  对应插入排序的 cur
            cur = nums[gap];

            // 从 gap 开始，以 gap 为间隔，开始对比 preIndex 的数值
            // 可以对比 插入排序算法， 只是将对比粒度从 1  变成了 gap，同时逐渐缩小粒度。
            for (int i = gap; i < len; i++) {

                int preIndex = i - gap;
                while (preIndex >= 0 && nums[preIndex] > cur) {
                    // 插入排序的 gap 为 1
                    nums[preIndex + gap] = nums[preIndex];
                    preIndex -= gap;
                }
                nums[preIndex + gap] = cur;
            }
            gap /= 2;
        }

        return nums;
    }
}
