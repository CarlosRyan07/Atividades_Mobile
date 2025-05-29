// 2) Implemente uma função que retorna o penúltimo elemento de uma lista.


fun <T> penultimate(list: List<T>): T {
    if (list.size < 2) throw NoSuchElementException("Lista com menos de dois elementos.")
    return list[list.size - 2]
}

fun main() {
    println(penultimate(listOf(1, 1, 2, 3, 5, 8))) // 5
}