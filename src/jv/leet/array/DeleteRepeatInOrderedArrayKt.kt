package jv.leet.array

// kotlin 实现， 删除有序数组的 重复项
class DeleteRepeatInOrderedArrayKt {

}

fun delete(array: MutableList<Int>): Int {

    if (array == null || array.size == 0) {
        return 0
    }

    var slow = 0
    var fast = 1

    while (fast < array.size) {

        if (array[slow] != array[fast]) {
            array[++slow] = array[fast]
        }

        fast++
    }

    return slow
}