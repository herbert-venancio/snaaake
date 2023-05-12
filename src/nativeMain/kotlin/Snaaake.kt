data class Snaaake(
    val cells: List<Cell>,
    val direction: Direction,
    val eatenApples: Int = 0
) {
    fun move(): Snaaake {
        val newHead = cells.first().move(direction)
        val newTail = if (eatenApples > 0) cells else cells.dropLast(1)
        return copy(
            cells = listOf(newHead) + newTail,
            eatenApples = maxOf(0, eatenApples - 1)
        )
    }

    fun turn(newDirection: Direction): Snaaake {
        if (newDirection.isOpposite(direction)) return this
        return copy(direction = newDirection)
    }

    fun eat(apples: Apples): Pair<Snaaake, Apples> {
        if (!apples.cells.contains(head)) return Pair(this, apples)
        return Pair(
            this.copy(eatenApples = eatenApples + 1),
            apples.copy(cells = apples.cells - head,
                score = apples.score + 1)
        )
    }

    val head: Cell = cells.first()
    val tail = cells.subList(1, cells.size)
}
