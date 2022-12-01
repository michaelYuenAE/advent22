fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:

    val input = readInput("input")

    val elfCaloriesMap = hashMapOf<Int, Int>()
    var calories = 0
    input.forEachIndexed { index, string ->
        if (string.isEmpty()) {
            elfCaloriesMap[index] = calories
            calories = 0
        } else {
            calories += string.toInt()
        }
    }
    val result = elfCaloriesMap.toList().sortedBy { (_,value) -> value }.map { it.second }.takeLast(3).sum()
    println(result)
}
