import kotlinx.cinterop.CPointer
import kotlinx.cinterop.memScoped
import ncurses.*

fun main() = memScoped {
    initscr()
    defer { endwin() }

    val width = 20
    val height = 10
    val window = newwin(height + 2, width + 2, 0, 0)!!
    defer { delwin(window) }

    curs_set(0)
    halfdelay(4)

    var game = Game(
        width,
        height,
        Snaaake(
            listOf(Cell(5, 5), Cell(5, 6), Cell(5, 7)),
            Direction.right
        )
    )

    var input = wgetch(window)
    while(input.toChar() != 'q') {
        if(game.isOver && input.toChar() == 'n') {
            game = Game(width, height, Snaaake(
                listOf(Cell(5, 5), Cell(5, 6), Cell(5, 7)),
                Direction.right
            ))
        }

        game.render(window)

        val direction = when(input.toChar()) {
            'w' -> Direction.up
            's' -> Direction.down
            'a' -> Direction.left
            'd' -> Direction.right
            else -> game.snake.direction
        }

        game = game.update(direction)

        input = wgetch(window)
    }
}

fun Game.render(window: CPointer<WINDOW>) {
    wclear(window)
    box(window, 0, 0)

    apples.render(window)
    snake.render(window)

    if (isOver) {
        mvwprintw(window, 1, 6, "Game Over")
        mvwprintw(window, 2, 2, "Your score was: ${apples.score}")
        mvwprintw(window, 3, 2, "Press 'q' to exit")
    }

    wrefresh(window)
}

fun Snaaake.render(window: CPointer<WINDOW>) {
    tail.forEach { mvwprintw(window, it.y + 1, it.x + 1, "o") }
    head.let { mvwprintw(window, it.y + 1, it.x + 1, "Q")}
}

fun Apples.render(window: CPointer<WINDOW>) {
    cells.forEach { mvwprintw(window, it.y + 1, it.x + 1, ".") }
}




