
private val CYCLE_INDEX = listOf(20, 60, 100, 140, 180, 220)
class Day10(private val input: List<String>) {
    private val command = input.map { getCommand(it) }

    fun solvePart1() = getSignalStrength()

    private fun getSignalStrength(): Int {
        var registerX = 1
        var sb = StringBuffer()
        var cycle = 0
        for (index in 1.. input.size) {
            val currentCommand = command[index - 1]
            sb.append(executeCycle(++cycle, registerX))
            //ADD X takes 2 cycles
            if (currentCommand is Command.addX) {
                sb.append(executeCycle(++cycle, registerX))
                registerX += currentCommand.xValue
            }
        }
        println(sb.toString())
        return 1
    }

    fun executeCycle(cycle: Int, registerX: Int): StringBuffer {
        val tempBuffer = StringBuffer()

        tempBuffer.append(if (listOf(registerX-1, registerX, registerX+1).contains((cycle-1)%40)) "##" else "..")

        if (listOf(40, 80, 120, 160, 200, 240).contains(cycle)) {
            tempBuffer.append("\n")
        }
        return tempBuffer
    }
}


fun main() {
    val day = "day10_input"
    println(Day10(readInput(day)).solvePart1())

}

fun getCommand(command: String): Command {
    val commandSplit = command.substringBefore(" ")
    return if (commandSplit == "noop") {
        Command.Noop
    } else {
        Command.addX(command.substringAfter(" ").toInt())
    }
}

sealed class Command {
    object Noop: Command()
    data class addX(val xValue: Int): Command()
}