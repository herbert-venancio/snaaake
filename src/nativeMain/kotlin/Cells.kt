data class Cell(
    val x: Int,
    val y: Int
) {
    fun move(direction: Direction): Cell = Cell(x + direction.dx, y + direction.dy)
}

enum class Direction(val dx: Int, val dy: Int) {
    up(0, -1), down(0, 1), left(-1, 0), right(1, 0);

    fun isOpposite(that: Direction): Boolean = dx + that.dx == 0 && dy + that.dy == 0
}
