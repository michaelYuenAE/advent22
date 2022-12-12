fun d10t3(lines: List<String>) {
    var registerX = 1
    val sb = StringBuffer()
    var cycle = 0
    for (line in 1 .. lines.size ) {
        val op = lines[line - 1].split(" ")
        sb.append(executeCycle3(++cycle, registerX))

        if (op[0] == "addx") {
            sb.append(executeCycle3(++cycle, registerX))
            registerX += op[1].toInt()
        }
    }
    println(sb.toString())
}

fun executeCycle3(cycle: Int, registerX: Int): StringBuffer {
    val tempBuffer = StringBuffer()

    tempBuffer.append(if (listOf(registerX - 1, registerX, registerX + 1).contains((cycle - 1) % 40)) "##" else "..")

    if (listOf(40, 80, 120, 160, 200, 240).contains(cycle)) {
        tempBuffer.append(System.lineSeparator())
    }
    return tempBuffer
}

fun main() {
    val day = "day10_input"
    println(d10t3(readInput(day)))

}