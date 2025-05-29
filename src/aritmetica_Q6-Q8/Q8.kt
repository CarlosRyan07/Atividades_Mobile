// 8) Implemente uma função que retorna a lista de números primos dentro de um intervalo especificado.

fun Int.isPrime(): Boolean {
    if (this < 2) return false
    for (i in 2..Math.sqrt(this.toDouble()).toInt()) {
        if (this % i == 0) return false
    }
    return true
}
fun listPrimesInRange(range: IntRange): List<Int> {
    return range.filter { it.isPrime() }
}

fun main() {
    println(listPrimesInRange(7..31)) // Saída: [7, 11, 13, 17, 19, 23, 29, 31]
}
