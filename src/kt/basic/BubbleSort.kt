package kt.basic

import java.util.*


class BubbleSort() {

    init {

        println("init bubble sort ")
    }

    fun sort(arr: IntArray) {

        var temp: Int


        for (i in arr.indices - 1) {

            for (j in arr.size - 1 downTo i + 1) {

                if (arr[j] < arr[j - 1]) {

                    temp = arr[j]
                    arr[j] = arr[j - 1]
                    arr[j - 1] = temp

                }
            }

        }

        println(Arrays.toString(arr))

    }


}


fun main() {

    println("main test start !")

    val sort = BubbleSort()
    sort.sort(intArrayOf(1, 23, 14, 91, 86, 14, 56, 72))

}