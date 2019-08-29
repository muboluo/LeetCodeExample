package kt.basic

import java.util.*

fun main() {


    print("main test start!")

    var arr = intArrayOf(1, 95, 14, 51, 44, 11)
    println(Arrays.toString(arr))

    SelectSort().sortBasic(arr)
    println(Arrays.toString(arr))

}

/**
 * 选择排序： index从第一位开始，依次进行比较。若发现比该位置小的数字，保存currentMinIndex。
 * 在该论循环结束后，将最小的替换到第一位。
 * index +1 继续遍历。
 * 直到最后一位。
 */

class SelectSort() {


    init {
        println("init select basic")
    }

    fun sortBasic(arr: IntArray) {


        for (i in 0 until arr.size - 1) {

            var minValueIndex = i

            for (j in i until arr.size) {

                if (arr[j] < arr[minValueIndex]) {
                    minValueIndex = j
                }

            }

            if (minValueIndex != i) {

                val temp = arr[minValueIndex]
                arr[minValueIndex] = arr[i]
                arr[i] = temp
            }
        }
    }


}

