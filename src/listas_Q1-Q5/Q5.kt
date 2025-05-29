// 5) Implemente uma função que decodifica run-length.
fun <T> decode(encoded: List<Pair<Int, T>>): List<T> {
    return encoded.flatMap { (count, value) -> List(count) { value } }
}

fun main() {
    val lista = listOf(Pair(4, 'a'), Pair(1, 'b'), Pair(2, 'c'), Pair(2, 'a'), Pair(1, 'd'), Pair(4, 'e'))
    println(decode(lista)) // Saída: [a, a, a, a, b, c, c, a, a, d, e, e, e, e]
}
