// 7) Implemente uma função que retorna o MDC de dois inteiros positivos (algoritmo de Euclides).
fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}

fun main() {
    println(gcd(36, 63)) // Saída: 9
}
