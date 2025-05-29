// 11) Implemente uma função que retorne os valores das folhas de uma árvore.

sealed interface Tree<out T> {
    override fun toString(): String
}

data class Node<out T>(
    val value: T,
    val left: Tree<T> = End,
    val right: Tree<T> = End
) : Tree<T> {
    override fun toString(): String {
        val children = if (left == End && right == End) "" else " ${left} ${right}"
        return "T($value$children)"
    }
}

object End : Tree<Nothing> {
    override fun toString(): String = "."
}

fun <T> Tree<T>.leafValues(): List<T> = when (this) {
    is End -> emptyList()
    is Node -> if (left is End && right is End)
        listOf(value)
    else
        left.leafValues() + right.leafValues()
}

fun main() {
    val tree = Node("a", Node("b"), Node("c", Node("d"), Node("e")))
    println(tree.leafValues()) // Saída: [b, d, e]
}

