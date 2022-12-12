

class Day06(val s: String) {
    init {
       println(s)
    }


    fun part1(): Int {
        s.forEachIndexed { index, char ->
            val first = s[index]
            val second = s[index+1]
            val third = s[index+2]
            val fourth = s[index+3]
            val charSet = mutableSetOf<Char>(first, second, third, fourth)
            if (charSet.size == 4)
                return index+4
        }
        return -1
    }

    fun part2(): Int {
        s.forEachIndexed { index, char ->
            if (index>= s.length - 13) {
                return -1
            }

            val charSet = s.substring(index, index+14).toSet()
            if (charSet.size == 14) {
                return index+14
            }
        }
        return -1
    }
}

fun main() {
    val day = "day6_input"


    val characters = Day06(readInput(day).first()).part2()
    println(characters)

}