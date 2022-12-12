
import kotlin.math.abs
import kotlin.math.sign

class Day9_Michael(private val input: List<String>) {
    private val motions = input.map { it.substringBefore(" ") to it.substringAfter(" ").toInt() }

    private val directions = mapOf(
        "U" to Point(0,1),
        "D" to Point(0,-1),
        "L" to Point(-1, 0),
        "R" to Point(1,0)
    )

    fun solvePart1() = visitedTailPositions(numberOfKnots = 2)

    fun solvePart2() = visitedTailPositions(numberOfKnots = 10)

    private fun visitedTailPositions(numberOfKnots: Int): Int {
        val knots = MutableList(numberOfKnots) { Point(0, 0)}
        val visited = mutableSetOf<Point>()

        motions.forEach { (direction, times) ->
            repeat(times) {
                knots.indices.windowed(2) {(head, tail) ->
                    knots[head] = knots[head].move(directions.getValue(direction))
                    if(!knots[tail].isNeighbourOf(knots[head])) {
                        knots[tail] = knots[tail].movedTo(knots[head])
                    }
                    visited.add(knots[tail])
                }
             }
        }

        return visited.size
    }

    private data class Point(val x: Int, val y: Int) {
        fun move(other: Point): Point = Point(this.x + other.x, this.y + other.y)

        infix fun movedTo(other: Point) = this.move(Point((other.x - x).sign, (other.y - y).sign))

        fun isNeighbourOf(other: Point) = abs(other.x - x) <2 && abs(other.y - y)<2
    }
}


fun main() {
    val day = "day9_input"
    println(Day9_Michael(readInput(day)).solvePart1())

}
