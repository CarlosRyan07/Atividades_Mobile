// 1) Implemente uma função que retorna o último elemento de uma lista.

fun <T> last(list: List<T>): T {
    if (list.isEmpty()) throw NoSuchElementException("A lista está vazia.")
    return list.last()
}

fun main() {
    val resultado = last(listOf(1, 1, 2, 3, 5, 8))
    println(resultado) // Saída: 8
}
