// 10) Implemente uma função que conte a quantidade de folhas de uma árvore.

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

// Função para contar o número de folhas na árvore
fun <T> Tree<T>.leafCount(): Int = when (this) {
    is End -> 0 // Se for o final da árvore, não há folhas
    is Node -> {
        // Se for uma folha (nós sem filhos), contamos 1, senão recursivamente contamos nas subárvores
        if (this.left == End && this.right == End) 1
        else this.left.leafCount() + this.right.leafCount()
    }
}

fun main() {
    // Exemplo de árvore
    val treeExample =
        Node('a',
            Node('b',
                Node('d'), 
                Node('e')
            ),
            Node('c', 
                End, 
                Node('f', Node('g'), End)
            )
        )

    println("Árvore: $treeExample")
    println("Número de folhas: ${treeExample.leafCount()}")
}
