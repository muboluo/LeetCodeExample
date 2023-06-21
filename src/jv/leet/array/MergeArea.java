package jv.leet.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间每个区间只有两个元素输入: intervals = [[1,3],[2,6],[8,10],[15,18]]输出:[[1,6],[8,10],[15,18]]解释: 区间[1,3]和[2,6] 重叠,将它们合并为 [1,6].
 * 输入: intervals = [[1,4],[4,5]]输出:[[1,5]]解释: 区间 [1,4] 和[4,5] 可被视为重香区间
 * https://leetcode.cn/problems/merge-intervals/solution/he-bing-qu-jian-by-leetcode-solution/
 */
public class MergeArea {

    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {

        if (intervals == null) {
            return new int[0][];
        }

        Arrays.sort(intervals, (x1, x2) -> {
            return x1[0] - x2[0];
        });

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {

            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[0]);
            }

        }

        return merged.toArray(new int[0][]);

    }
}
