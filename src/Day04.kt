fun main() {

    val input = readInput("day4_input")
    println(part2(input))
}


fun part1(input: List<String>): Int {
    return input.map { it.split(",", "-").map { it.toInt() } }.count {
        val (first, second, third, fourth) = it
        println("first $first second $second third $third fourth $fourth")
        (first in third..fourth && second in third..fourth) || (third in first..second && fourth in first..second)
    }
}


fun part2(input: List<String>): Int {
    return input.map { it.split(",", "-").map { it.toInt() } }.count {
        val (first, second, third, fourth) = it
        (first in third..fourth || second in third..fourth) || (third in first..second || fourth in first..second)
    }
}


fun solvePart1(input: List<String>): Int {
    var counter = 0

    input.forEach {
        val firstElfStart = it.split(',')[0].split('-')[0]
        val firstElfEnd = it.split(',')[0].split('-')[1]
        val secondElfStart = it.split(',')[1].split('-')[0]
        val secondElfEnd = it.split(',')[1].split('-')[1]

        println("first $firstElfStart second $firstElfEnd third $secondElfStart fourth $secondElfEnd")
        val firstElfSet = mutableSetOf<Int>()

        for (i in firstElfStart.toInt() .. firstElfEnd.toInt()) {
            firstElfSet.add(i)
        }

        val secondElfSet = mutableSetOf<Int>()

        for (i in secondElfStart.toInt() ..  secondElfEnd.toInt()) {
            secondElfSet.add(i)
        }
        println("firstElfSet $firstElfSet")
        println("secondElfSet $secondElfSet")
        if (firstElfSet.intersect(secondElfSet).isNotEmpty() || secondElfSet.intersect(firstElfSet).isNotEmpty()) {
            counter++
        }
    }
    return counter

}