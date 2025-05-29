// 3) Implemente uma função que verifica se uma lista é palíndroma.
fun <T> isPalindrome(list: List<T>): Boolean {
    return list == list.reversed()
}

fun main() {
    println(isPalindrome(listOf(1, 2, 3, 2, 1))) // Saída: true
}
