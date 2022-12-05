fun main() {
    fun part1(input: List<String>): Int {

//        val letterScoreMap = getMap()
//        var sum = 0
//        input.forEach {
//            val firstCompartment = it.substring(0, (it.length/2)).toSet()
//            val secondCompartment = it.substring((it.length/2), it.length).toSet()
//            val intersect = firstCompartment.intersect(secondCompartment)
//            val total = getScore(intersect, letterScoreMap)
//            println("intersect, $intersect")
//            println("total, $total")
//            sum += total
//        }
        return input.size
    }

    val input = readInput("day3_input")
    println(Day3(input).solvePart2())
}


class Day3(input: List<String>) {

    private val priorities = let {
        var priority = 1
        (('a'..'z') + ('A'..'Z')).associateWith { priority++ }
    }

    private fun Char.priority() = priorities.getValue(this)

    /**
     * List of elf groups, each elf in each group have a rucksack with a set containing all items
     * (ignoring the compartments)
     */
    private val elfGroups = input.map { it.toSet() }.chunked(3)


    fun solvePart2(): Int {
        println(elfGroups)
        return elfGroups.sumOf { it[0].intersect(it[1]).intersect(it[2]).first().priority() }
    }
}