import kotlin.random.Random

data class Apples(
    val width: Int,
    val height: Int,
    val cells: Set<Cell> = emptySet(),
    val score: Int = 0,
    val random: Random = Random
) {
    fun grow(): Apples {
        if (random.nextInt(10) >= 3) return this
        return copy(cells = cells + Cell(random.nextInt(width), random.nextInt(height)))
    }
}
