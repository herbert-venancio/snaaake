import kotlin.test.Test
import kotlin.test.assertEquals

class SnaaakeTest {

    @Test
    fun `snake moves right`() {
        // given
        val snake = Snaaake(
            listOf(Cell(2, 0), Cell(1, 0), Cell(0, 0)),
            Direction.right
        )

        //when
        val newState = snake.move()

        // then
        assertEquals(
            newState,
            Snaaake(
                listOf(Cell(3, 0), Cell(2, 0), Cell(1, 0)),
                Direction.right
            )
        )

    }
}
