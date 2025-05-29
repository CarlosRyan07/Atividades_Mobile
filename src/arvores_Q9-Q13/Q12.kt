// 12) Implemente uma função que imprima uma árvore com a notação mostrada no exemplo.

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

fun Tree<String>.convertToString(): String = when (this) {
    is End -> ""
    is Node -> {
        val leftStr = left.convertToString()
        val rightStr = right.convertToString()
        if (leftStr.isEmpty() && rightStr.isEmpty()) value
        else "$value(${leftStr},${rightStr})"
    }
}

fun main() {
    val tree = Node("a", Node("b", Node("d"), Node("e")), Node("c", End, Node("f", Node("g"))))
    println(tree.convertToString()) // Saída: a(b(d,e),c(,f(g,)))
}
