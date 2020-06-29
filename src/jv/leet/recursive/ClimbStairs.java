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
 * 本题目是常见的动态规划的题目
 * 我们可以把他分解成多个子问题，来进行求解。
 * 我们设爬到第n个台阶的方法数的求分级方法 为 f(n)
 * 则爬到第n个台阶的最后一步一共有两种方法，
 * 分别是最后跨一个台阶和 跨两个台阶。
 * 分别是从第 n-1个台阶 和 第n-2个台阶爬上来的。
 * 爬n个台阶的方法为f(n),因此，我们可以推导出 n-1 和 n-2个台阶的方法
 * f(n-1) 和 f(n-2)
 * 由此，我们可以推导出。f(n) = f(n-1) + f(n-2)
 * 因此我们可以采用for 或者递归的形式进行解答。
 * 但我再提交 leetcode的时候，采用递归的方式提交总是报超时的错误。
 * 所以我们这里采用的for 循环的结题方式提交的答案。
 * 不过，在这里，仍将递归的答案列在这里。
 */

public class ClimbStairs {

    public int climbStairsRecursive(int n) {

        //terminal
        if (n <= 1) {
            return 1;
        } else if (n <= 2) {
            return n;
        }

        //current level handle
        int result = climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
        //jump next level

        // reset clause

        return result;

    }

    public int climbStairsArray(int n) {

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

        return count[n - 1];

    }

    public static void main(String[] args) {

        int result = new ClimbStairs().climbStairsRecursive(10);

        System.out.println(result);

        int result2 = new ClimbStairs().climbStairsArray(10);

        System.out.println(result2);

    }

}
