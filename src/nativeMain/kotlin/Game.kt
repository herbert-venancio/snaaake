
data class Game(
    val width: Int,
    val height: Int,
    val snake: Snaaake,
    val apples: Apples = Apples(width, height)
) {
    val isOver: Boolean =
        snake.tail.contains(snake.head)
                || snake.cells.any {
            it.x < 0 || it.x >= width || it.y < 0 || it.y >= height
        }

    fun update(direction: Direction): Game {
        if (isOver) return this

        val (newSnake, newApples) = snake.turn(direction).move().eat(apples.grow())

        return copy(
            snake = newSnake,
            apples = newApples
        )
    }
}
