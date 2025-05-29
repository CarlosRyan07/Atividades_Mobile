// 4) Implemente uma função que recebe uma lista com repetições e retorna uma lista com codificação run-length.
fun <T> encode(list: List<T>): List<Pair<Int, T>> {
    return list.fold(mutableListOf()) { acc, item ->
        if (acc.isNotEmpty() && acc.last().second == item) {
            val (count, value) = acc.removeAt(acc.size - 1)
            acc.add(Pair(count + 1, value))
        } else {
            acc.add(Pair(1, item))
        }
        acc
    }
}

fun main() {
    println(encode("aaaabccaadeeee".toList())) // Saída: [(4, a), (1, b), (2, c), (2, a), (1, d), (4, e)]
}
