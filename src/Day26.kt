import java.io.File

class Day26 {
    fun part1(): String {
        var sum: Long = 0
        for (s in input!!.split("\n".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
            val number = StringBuilder(s).reverse().toString()
            var num: Long = 0
            for (i in 0 until number.length) {
                val place = Math.pow(5.0, i.toDouble())
                when (number[i]) {
                    '=' -> num += (-2L * place).toLong()
                    '-' -> num += (-1L * place).toLong()
                    '1' -> num += place.toLong()
                    '2' -> num += (2L * place).toLong()
                }
            }
            sum += num
        }
        return numBuilder(sum)?: "dkasdadsa"
    }

    fun numBuilder(num: Long): String? {
        return if (num == 0L) "" else when ((num % 5).toInt()) {
            0 -> numBuilder(num / 5L) + "0"
            1 -> numBuilder(num / 5L) + "1"
            2 -> numBuilder(num / 5L) + "2"
            3 -> numBuilder((num + 2) / 5L) + "="
            4 -> numBuilder((num + 1) / 5L) + "-"
            else -> null
        }
    }

    fun part2(): String {
        return "Merry Christmas!"
    }

    companion object {
        var input: String? = null
        @JvmStatic
        fun main(args: Array<String>) {
            input = File("/Users/michaelyuen/Desktop/advent22/src", "day26_input.txt").readText()
            println(Day26().part2())
        }
    }
}