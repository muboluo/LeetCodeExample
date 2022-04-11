package jv.leet.recursive;

/**
 * 爬楼梯的题目： https://leetcode-cn.com/problems/climbing-stairs/
 * <p>
 * 题目描述：
 * <p>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 解题思路：
 * <p>
 * 本题目是常见的动态规划的题目
 * 我们可以把他分解成多个子问题，来进行求解。
 * <p>
 * 我们设爬到第n个台阶的方法数的求分级方法 为 f(n)
 * 则爬到第n个台阶的最后一步一共有两种方法，
 * 分别是最后跨一个台阶和 跨两个台阶。
 * <p>
 * 分别是从第 n-1个台阶 和 第n-2个台阶爬上来的。
 * 爬n个台阶的方法为f(n),因此，我们可以推导出 n-1 和 n-2个台阶的方法
 * f(n-1) 和 f(n-2)
 * <p>
 * 由此，我们可以推导出。f(n) = f(n-1) + f(n-2)
 * 因此我们可以采用for 或者递归的形式进行解答。
 * <p>
 * 但我在提交 leetcode 的时候，采用递归的方式提交总是报超时的错误。
 * 所以我们这里采用的for 循环的结题方式提交的答案。
 * 不过，在这里，仍将递归的答案列在这里。
 */

public class ClimbStairs {

    // 通过递归的方式，处理 - 第一遍
    public static int climbStairsRecursive(int n) {

        //terminal ，递归到最后一级的结果。
        if (n <= 2) {
            return n;
        }

        //current level handle， 处理当前层级的实现。
        int result = climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
        //jump next level 跳转到下一个层级

        // reset clause 重置递归条件

        return result;

    }

    // 通过数组的方式处理 - 第一遍
    // 数组中存储的 value ，是走到当前层级，一共需要多少步。
    public static int climbStairsArray(int n) {

        // 特例，与 递归一样。
        if (n <= 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        int[] count = new int[n];

        count[0] = 1;
        count[1] = 2;

        for (int i = 2; i < count.length; ++i) {

            count[i] = count[i - 1] + count[i - 2];
        }

        System.out.println(count[n - 1]);
        return count[n - 1];

    }

    public static void main(String[] args) {

        int result = climbStairsRecursive(20);
        System.out.println(result);
        int result2 = climbStairsRecursive2(20);
        System.out.println(result2);
        int result3 = climbStairsRecursive3(20);
        System.out.println(result3);

        climbStairsArray(20);
        climbStairsArray2(20);
        climbStairsArray3(20);

    }

    // 爬楼梯 - 数组形式解决 - 第三遍
    private static void climbStairsArray3(int n) {

        if (n <= 2) {
            return;
        }

        int[] resultArray = new int[n];
        resultArray[0] = 1;
        resultArray[1] = 2;

        for (int i = 2; i < resultArray.length; i++) {
            resultArray[i] = resultArray[i - 1] + resultArray[i - 2];
        }

        System.out.println(resultArray[n - 1]);


    }

    // 爬楼梯-递归 - 第三遍
    private static int climbStairsRecursive3(int n) {
        // 递归四步骤
        // terminal
        if (n <= 2) {
            return n;
        }

        // current level handle
        int result = climbStairsRecursive3(n - 1) + climbStairsRecursive3(n - 2);

        // jump next level

        // reset clause
        return result;
    }

    // 爬楼梯 - 数组形式 - 第二遍
    private static int climbStairsArray2(int n) {

        if (n <= 2) {
            return n;
        }

        int[] result = new int[n];

        result[0] = 1;
        result[1] = 2;

        for (int i = 2; i < result.length; i++) {

            result[i] = result[i - 1] + result[i - 2];
        }

        System.out.println(result[n - 1]);

        return result[n - 1];
    }

    // 递归实现 - 第二遍
    private static int climbStairsRecursive2(int n) {

        // 递归四步骤

        // terminal
        if (n <= 2) {
            return n;
        }

        // current level handle
        int result = climbStairsRecursive2(n - 1) + climbStairsRecursive2(n - 2);
        // jump next level

        // reset clause

        return result;
    }

}
