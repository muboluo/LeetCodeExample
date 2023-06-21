package jv.leet.array;

/**
 * 给你两个有序整数数组 nums1和 nums2，请你将nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
 * 初始化 nums1和 nums2 的元素数量分别为 m和n。你可以假设 nums1 有足够的空间(空间大小大于或等于 m +n )来保存 nums2 中的元素。两个数组都部不为空
 * <p>
 * // 合并两个有序数组
 * 链接：https://leetcode.cn/problems/merge-sorted-array/solution/he-bing-liang-ge-you-xu-shu-zu-by-leetco-rrb0/
 */
public class Merge2SortedArray {

    public static void main(String[] args) {

    }

    // m 表示第一个数组的有效数字范围，不是长度。
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {

        if (nums1 == null && nums2 == null) {
            return new int[0];
        } else if (nums1 == null) {
            return nums2;
        } else if (nums2 == null) {
            return nums1;
        }

        int[] result = new int[m + n];

        int i = 0, j = 0, cur = 0;

        while (i < m || j < n) {

            if (i >= m) {
                result[cur++] = nums2[j++];
            } else if (j >= n) {
                result[cur++] = nums2[i++];
            } else if (nums1[i] <= nums2[j]) {
                result[cur++] = nums1[i++];
            } else {
                result[cur++] = nums1[j++];
            }
        }
        return result;
    }

    public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {

        if (nums1 == null && nums2 == null) {
            return new int[0];
        } else if (nums1 == null) {
            return nums2;
        } else if (nums2 == null) {
            return nums1;
        }

        int k1 = m - 1, k2 = n - 1, cur = m + n - 1;

        while (k1 >= 0 || k2 >= 0) {

            if (k1 < 0) {
                nums1[cur--] = nums1[k2--];
            } else if (k2 < 0) {
                nums1[cur--] = nums1[k1--];
            } else if (nums1[k1] > nums1[k2]) {
                nums1[cur--] = nums1[k1--];
            } else {
                nums1[cur--] = nums1[k2--];
            }
        }
        return nums1;
    }
}
