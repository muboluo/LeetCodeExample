package jv.sevenday;

/**
 * 题目要求： 将 一个有序数组中，删除相同项，并计算出非重复数据的长度。
 * 地址：
 * 思路： 采用双指针法，增加维度。
 * 1 一个慢指针，一个快指针。 从0开始判断。因为数组有序，所以如果有相同项，他们肯定是相邻的。
 * 所以现在有两种情况：
 * ① nums[i] 与 nums[j]之间没有重复项
 * ② nums[i] 与 nums[j]之间有重复项
 * <p>
 * ① 若 nums[i] 与 nums[j] 之间有重复项：
 * nums[i+1] 为第一个出现重复项的位置。使用 nums[j] 覆盖 nums[i+1]，这样就消除了nums[i] != nums[i+1],从第一项至 i 项就没有了重复项。
 * j++ 之后，继续判断，若二者相同，j继续后移，寻找下一个不同的数值。若二者不同，则将新的数值存储至 nums[i+1]中。
 *
 * @ 若 nums[i] 与 nums[j]之间没有重复项
 * nums[j] 赋值给 nums[i+1]， j++ 对下一个值做判断。从第一项至 i 项，仍然没有重复项。
 * <p>
 * 直到最后一项，此时，从 0 到 下标i指向的是最新的生成的没有重复项的数组。 数组长度为 i+1
 * <p>
 * 2 注意边界条件的判断，eg: 数组为空该怎么处理？
 */
class MoveZero {

    public int MoveZeroTest(int nums[]) {

        if (nums.length == 0) {
            return 0;
        }

        int i= 0;

        for (int j = 0; j < nums.length; ++j) {

            if (nums[i] != nums[j]) {

                nums[++i] = nums[j];

            }

        }
        return i + 1;

    }

}
