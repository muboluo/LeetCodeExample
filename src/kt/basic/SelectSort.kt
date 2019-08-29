package kt.basic

import java.util.*

fun main() {


    print("main test start!")

    var arr = intArrayOf(1, 95, 14, 51, 44, 11)
    println(Arrays.toString(arr))

    SelectSort().sortBasic(arr)
    println(Arrays.toString(arr))

}

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

