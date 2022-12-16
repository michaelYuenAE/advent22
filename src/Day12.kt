//class Day12 {
//
//    fun partOne(): Int = createField()
//        .let { (field, start, end) ->
//            findShortestPath(mutableListOf(field[start]!!), field, end)
//        }
//
//    fun partTwo(): Int = createField()
//        .let { (field, _, end) ->
//            field.values
//                .filter { it.height == 'a' }
//                .map { findShortestPath(mutableListOf(it), createField().first, end) }
//                .minOf { it }
//        }
//
//    private fun createField(): Triple<MutableMap<Pair<Int, Int>, Point2>, Pair<Int, Int>, Pair<Int, Int>> {
//        val field = mutableMapOf<Pair<Int, Int>, Point2>()
//
//        var start: Pair<Int, Int> = Pair(-1, -1)
//        var end: Pair<Int, Int> = Pair(-1, -1)
//
//        readInput("day12_input").forEachIndexed { y, line ->
//            line.toCharArray().forEachIndexed { x, char ->
//                when (char) {
//                    'S' -> {
//                        start = Pair(x, y)
//                        field[start] = Point2(coordinates = start, height = 'a')
//                    }
//
//                    'E' -> {
//                        end = Pair(x, y)
//                        field[end] = Point2(coordinates = end, height = 'z')
//                    }
//
//                    else -> {
//                        field[Pair(x, y)] = Point2(coordinates = Pair(x, y), height = char)
//                    }
//                }
//            }
//        }
//        return Triple(field, start, end)
//    }
//
//    private fun findShortestPath(
//        toVisit: MutableList<Point2>,
//        allPoints: MutableMap<Pair<Int, Int>, Point2>,
//        end: Pair<Int, Int>
//    ): Int {
//        var moves = 0
//        while (toVisit.isNotEmpty()) {
//            moves++
//
//            val nextToVisit = mutableSetOf<Point2>()
//            for (point in toVisit) {
//                val left = allPoints.getOrElse(Pair(point.coordinates.first - 1, point.coordinates.second)) { null }
//                if ((left?.height ?: Char.MAX_VALUE).code <= point.height.code + 1 && left?.visited == false) {
//                    nextToVisit.add(left)
//                }
//
//                val right = allPoints.getOrElse(Pair(point.coordinates.first + 1, point.coordinates.second)) { null }
//                if ((right?.height ?: Char.MAX_VALUE).code <= point.height.code + 1 && right?.visited == false) {
//                    nextToVisit.add(right)
//                }
//
//                val up = allPoints.getOrElse(Pair(point.coordinates.first, point.coordinates.second - 1)) { null }
//                if ((up?.height ?: Char.MAX_VALUE).code <= point.height.code + 1 && up?.visited == false) {
//                    nextToVisit.add(up)
//                }
//
//                val down = allPoints.getOrElse(Pair(point.coordinates.first, point.coordinates.second + 1)) { null }
//                if ((down?.height ?: Char.MAX_VALUE).code <= point.height.code + 1 && down?.visited == false) {
//                    nextToVisit.add(down)
//                }
//
//                point.visited = true
//            }
//
//            if (nextToVisit.any { it.coordinates == end }) {
//                return moves
//            } else {
//                toVisit.clear()
//                toVisit.addAll(nextToVisit)
//            }
//        }
//
//        return Int.MAX_VALUE
//    }
//}
//
//data class Point(
//    val coordinates: Pair<Int, Int>,
//    val height: Char,
//    var visited: Boolean = false
//)
//fun main() {
//
//    println(Day12().partTwo())
//}
