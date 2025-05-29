// 13) Implemente uma função que a partir da representação em string gere uma árvore.

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

fun String.convertToTree(): Tree<String> {
    if (this.isEmpty()) return End

    fun parseTree(index: Int): Pair<Tree<String>, Int> {
        var i = index
        val value = StringBuilder()
        while (i < this.length && this[i] != '(' && this[i] != ',' && this[i] != ')') {
            value.append(this[i])
            i++
        }

        if (i >= this.length || this[i] != '(') return Pair(Node(value.toString()), i)

        i++ // '('
        val (left, nextI1) = parseTree(i)
        i = nextI1 + 1 // Skip ','

        val (right, nextI2) = parseTree(i)
        i = nextI2 + 1 // Skip ')'

        return Pair(Node(value.toString(), left, right), i)
    }

    return parseTree(0).first
}

fun main() {
    val tree = "a(b(d,e),c(,f(g,)))".convertToTree()
    println(tree) // Saída esperada: T(a T(b T(d) T(e)) T(c . T(f T(g) .)))
}

