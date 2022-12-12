class Day08(private val lines: List<String>) {
    val column = lines.first().length - 1
    val row = lines.size - 1
    val treeSet = mutableSetOf<Tree>()

    fun part1(): Int {

        println("column $column")
        println("row $row")
        lookFromWest(lines)
        lookFromEast(lines)
        lookFromNorth(lines)
        lookFromSouth(lines)
        return treeSet.size
    }

    private fun lookFromWest(lines: List<String>) {
        for (r in 0..row) {
            var tallest = -1
            val rowLine = lines[r]
            for (c in 0..column) {
                if (rowLine[c].code > tallest) {

                    println("lookFromWest column $c row $r value ${rowLine[c].code}")
                    tallest = rowLine[c].code
                    treeSet.add(Tree(r, c))
                }
            }
        }
    }

    private fun lookFromEast(lines: List<String>) {
        for (r in 0..row) {
            var tallest = -1
            val rowLine = lines[r]
            for (c in column downTo 0) {
                if (rowLine[c].code > tallest) {

                    println("lookFromEast column $c row $r value ${rowLine[c].code}")
                    tallest = rowLine[c].code
                    treeSet.add(Tree(r, c))
                }
            }
        }
    }

    private fun lookFromNorth(lines: List<String>) {
        for (c in 0..column) {
            var tallest = -1
            for (r in 0..row) {
                val tree = lines[r][c]

                if (tree.code > tallest) {
                    tallest = tree.code
                    treeSet.add(Tree(r,c))
                    println("lookFromNorth column $c row $r value $tallest")
                }
            }
        }
    }

    private fun lookFromSouth(lines: List<String>) {
        for (c in 0..column) {
            var tallest = -1
            for (r in row downTo 0) {
                val tree = lines[r][c]

                if (tree.code > tallest) {
                    tallest = tree.code
                    treeSet.add(Tree(r,c))
                    println("lookFromSouth column $c row $r value $tallest")
                }
            }
        }
    }
}

class Day08Other(input: List<String>) {
    private val grid = input.map { it.toList().map(Char::digitToInt) }

    fun solvePart1() = traverse(
        score = { current, slice -> slice.all { it < current } },
        combine = { directions -> if (directions.any { it }) 1 else 0 }
    ).sum()

    fun solvePart2() = traverse(
        score = { current, slice -> (slice.indexOfFirst { it >= current } + 1).takeIf { it != 0 } ?: slice.size },
        combine = { it.reduce(Int::times) }
    ).max()

    private fun <T> traverse(score: (Int, List<Int>) -> T, combine: (List<T>) -> Int): List<Int> {
        return (grid.indices).flatMap { r ->
            (grid.indices).map { c ->
                val current = grid[r][c]
                val up = score(current, grid.slice(r - 1 downTo 0).map { it[c] })
                val down = score(current, grid.slice(r + 1 until grid.size).map { it[c] })
                val left = score(current, grid[r].slice(c - 1 downTo 0))
                val right = score(current, grid[r].slice(c + 1 until grid.size))
                combine(listOf(up, down, left, right))
            }
        }
    }
}


fun main() {
//    val numbers = listOf(1, 1, 1)
//    val result = numbers.reduce { a: Int, b: Int -> a + b }
//    println("reduceResult=$result")//result=3
    val numbers = listOf(1, 1, 1)
    val result = numbers.fold(StringBuilder()) {
            str: StringBuilder, i: Int -> str.append(i).append(" ")
    }
    println("foldResult=$result")

//    val day = "day8_input"
//    println(Day08Other(readInput(day)).solvePart2())

}

data class Tree(val row: Int, val column: Int)