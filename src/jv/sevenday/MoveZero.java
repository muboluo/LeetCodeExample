package jv.sevenday;

/**
 * 题目要求： 将 一个有序数组中，删除相同项，并计算出非重复数据的长度。
 * 地址：
 * 思路： 采用双指针法，增加维度。
 * 1 一个慢指针，一个快指针。 从0开始判断。因为数组有序，所以如果有相同项，他们肯定是相邻的。
 * 2 首先比较第0项和第一项，若二者相同，（设相同值为x）不对i操作，j++, j 指向下一个item。之后，不管j++多少次，只要 nums[i] == nums[j].
 * i均不作操作。始终指向最初出现x的位置。
 * 3 若nums[i] != nums[j]，(nums[j] = y ),i++ i自增1 。指向第二个出现x的位置。并将
 */
class MoveZero {

    public int MoveZeroTest(int nums[]) {

        if (nums.length == 0) {
            return 0;
        }

        int i = 0;

        for (int j = 1; j < nums.length; ++j) {

            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

    }

}
