fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
//    shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
    val input = readInput("day2_input")

    var totalScore = 0
    input.forEach {
        val opponent = it.split(" ")[0]
        val myself = it.split(" ")[1]
//        println("opponent $opponent myself $myself")

        totalScore += getGameScore2(opponent, myself)
    }



    println(totalScore)
}

private fun getGameScore2(opponent: String, myself: String): Int {
    var shapeScore = 0
    val gameScore =  when (myself) {
        "X" -> {
            shapeScore = getLoseScore(opponent)
            0
        }
        "Y" -> {
            shapeScore = getDrawScore(opponent)
            3
        }
        else -> {
            shapeScore = getWinScore(opponent)
            6
        }
    }
    return shapeScore + gameScore
}

//shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
private fun getLoseScore(letter: String): Int {
    return when(letter) {
        "A" -> 3
        "B" -> 1
        "C" -> 2
        else -> -1000000

    }
}

//shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
private fun getDrawScore(letter: String): Int {
    return when(letter) {
        "A" -> 1
        "B" -> 2
        "C" -> 3
        else -> -1000000

    }
}

//shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
private fun getWinScore(letter: String): Int {
    return when(letter) {
        "A" -> 2
        "B" -> 3
        "C" -> 1
        else -> -1000000

    }
}


private fun getShapeScore2(letter: String): Int {
    return when(letter) {
        "X" -> 1
        "Y" -> 2
        "Z" -> 3
        else -> -1000000
    }
}

//    A for Rock, B for Paper, and C for Scissors
//    X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win.
//    outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
private fun getGameScore(opponent: String, myself: String): Int {
    return if ((opponent == "A" && myself == "X") || (opponent == "B" && myself == "Y") || (opponent == "C" && myself == "Z")) {
        3    //draw
    } else if ((opponent == "A" && myself == "Y") || (opponent == "B" && myself == "Z") || (opponent == "C" && myself == "X") ){
        6
    } else {
        0
    }
}

private fun getShapeScore(letter: String): Int {
    return when(letter) {
        "X" -> 1
        "Y" -> 2
        "Z" -> 3
        else -> -1000000
    }
}
