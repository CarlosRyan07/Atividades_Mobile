// 9) Implemente uma função para adicionar nós em uma árvore binária de busca.

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

fun <T : Comparable<T>> Tree<T>.add(newValue: T): Tree<T> = when (this) {
    End -> Node(newValue)
    is Node -> when {
        newValue < value -> copy(left = left.add(newValue))
        newValue > value -> copy(right = right.add(newValue))
        else -> this // ignora duplicatas
    }
}

fun main() {
    var bst: Tree<Int> = End
    val values = listOf(50, 30, 70, 20, 40, 60, 80, 30) // inclui duplicata
    for (v in values) {
        bst = bst.add(v)
    }
    println(bst)
}
