package jv.leet.array;

/**
 * 11. 盛最多水的容器
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)
 * 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * <p>
 * key: 如果我们试图将指向较长线段的指针向内移动，移动后，新形成的矩形，受限于先前较小的线段的概率会更大。我们的目标是寻找新的受限条件，
 * 而不是替换不受限的条件。
 * 我们只有在X轴不断减小的同时，寻找更高的Y轴线段才能获得更大的矩形。
 */
class MaxArea {

    public int maxArea(int[] height) {

        int l = 0, r = height.length - 1, maxArea = 0;

        while (l < r) {
            maxArea = Math.max(maxArea, (r - l) * Math.min(height[l], height[r]));

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }

}
