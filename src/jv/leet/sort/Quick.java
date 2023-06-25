package jv.leet.sort;

// 快速排序

import java.util.Arrays;

/**
 * 快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：
 * <p>
 * 从数列中挑出一个元素，称为 “基准”（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * <p>
 * 解题思路
 * 使用了递归的的方法，一层层缩小范围
 * 借助两个辅助方法
 * 根据 pivot ，找到分隔前后两个数组的 index
 * 交换 两个指定 index 的 值
 */
public class Quick {

    public static void main(String[] args) {

    }

    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        return quickSort(arr, 0, arr.length - 1);
    }

    private int[] quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partitionIndex = partition(arr, left, right);
            // 比 partitionIndex 小的，都在他左边，比他大的，都咋他右边。
            // 所以没有必要在对他进行比较。
            quickSort(arr, left, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, right);
        }
        return arr;
    }

    // 将所有比 pivot 小的，都挪到 pivot 的左边。右边上下的就是 比 pivot 大的了。
    // 最后将 pivot 指向的 index 返回。
    private int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
