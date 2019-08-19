package kt.basic

import java.util.*

/**
 *
 * 1 .基本的冒泡排序法
 * 2. 进阶版，若我们在排序过程中，发现其中有一次没有发生改变，那么就判定本次排序结束了。
 *    这样可以节省排序时间。
 */
class BubbleSort() {

    init {

        println("init bubble sortBasic ")
    }

    fun sortBasic(arr: IntArray) {

        var temp: Int

        var changeTime: Int = 0


        for (i in arr.indices - 1) {

            for (j in arr.size - 1 downTo i + 1) {

                if (arr[j] < arr[j - 1]) {

                    temp = arr[j]
                    arr[j] = arr[j - 1]
                    arr[j - 1] = temp

                }
            }

            changeTime++

        }

        println("basic sort : ${Arrays.toString(arr)}")
        println("change time $changeTime")

    }


    fun sortUpgrade(arr: IntArray) {

        var temp: Int
        var changeTime: Int = 0

        for (i in arr.indices - 1) {

            var changed: Boolean = false

            for (j in arr.size - 1 downTo i + 1) {

                if (arr[j] < arr[j - 1]) {

                    temp = arr[j]
                    arr[j] = arr[j - 1]
                    arr[j - 1] = temp

                    changed = true
                }
            }

            changeTime++


            if (!changed) {
                break
            }
        }

        println("upgrade  sort : ${Arrays.toString(arr)}")
        println("change time $changeTime")

    }


}


fun main() {

    println("main test start !")

    val sort = BubbleSort()
    sort.sortBasic(intArrayOf(1, 14, 23, 91, 14, 56, 72, 86))

    sort.sortUpgrade(intArrayOf(1, 14, 23, 91, 14, 56, 72, 86))

}