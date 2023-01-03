//val monkeys= readInput("day21_input_test").map {
//    getMonkey(it)
//}
////e.g.
////* root = pppw = sjmn (we know sjmm is 150) so pppw must be 150 as well
////* pppw = cczh / lfqf (we know lfgf is 4 so it becomes 150 = cczh / 4 so cczh = 600
////* cczh = sllz + lgvd (we know cczh is 600, sllz is 4 so lgvd is 596) ... and so on
//
//fun main() {
////    prLongln(monkeys)
//    val root = monkeys.indexOfFirst { it.first == "pppw" }
//
//    val rootMonkey = monkeys[root].second as Monkey.OperatorMonkey
//    val rf = monkeys.first { it.first == rootMonkey.firstMonkey }.second
//    val rs = monkeys.first { it.first == rootMonkey.secondMonkey }.second
//    println(calculateMonkey(rf, rs, rootMonkey.operator))
//}
//
//fun calculateMonkey(firstMonkey: Monkey, secondMonkey: Monkey, operator: String): Long {
//    if (firstMonkey is Monkey.NumberMonkey && secondMonkey is Monkey.NumberMonkey) {
//        return calculate(firstMonkey.number, secondMonkey.number, operator)
//    }
//    else if (firstMonkey is Monkey.OperatorMonkey && secondMonkey is Monkey.NumberMonkey) {
//        val f = monkeys.first { it.first == firstMonkey.firstMonkey }.second
//        val s = monkeys.first { it.first == firstMonkey.secondMonkey }.second
//        return calculate(calculateMonkey(f, s, firstMonkey.operator), secondMonkey.number, operator)
//    }
//    else if (firstMonkey is Monkey.NumberMonkey && secondMonkey is Monkey.OperatorMonkey) {
//        val f = monkeys.first { it.first == secondMonkey.firstMonkey }.second
//        val s = monkeys.first { it.first == secondMonkey.secondMonkey }.second
//        return calculate(firstMonkey.number, calculateMonkey(f, s, secondMonkey.operator), operator)
//    } else if (firstMonkey is Monkey.OperatorMonkey && secondMonkey is Monkey.OperatorMonkey) {
//        // both operator
//        val ff = monkeys.first { it.first == firstMonkey.firstMonkey }.second
//        val fs = monkeys.first { it.first == firstMonkey.secondMonkey }.second
//
//        val sf = monkeys.first { it.first == secondMonkey.firstMonkey }.second
//        val ss = monkeys.first { it.first == secondMonkey.secondMonkey }.second
//        return calculate(calculateMonkey(ff, fs, firstMonkey.operator), calculateMonkey(sf, ss, secondMonkey.operator), operator)
//    }
//    return -1
//}
//
//private fun calculate(first: Long, second: Long, operator: String): Long  {
//    return when(operator) {
//        "+" -> return first + second
//        "-" -> return first - second
//        "*" -> return first * second
//        "/" -> return first / second
//        else -> { -1 }
//    }
//}
////
////fun calculateMonkey(firstMonkeyName: String, secondMonkeyName: String, operator: String): Long {
////    val firstMonkey = monkeys.first { it.first == firstMonkeyName }
////    val secondMonkey = monkeys.first { it.first == secondMonkeyName }
////    if (firstMonkey.second is Monkey.NumberMonkey && secondMonkey.second is Monkey.NumberMonkey) {
////        val numberFirstMonkey = firstMonkey.second as Monkey.NumberMonkey
////        val numberSecondMonkey = secondMonkey.second as Monkey.NumberMonkey
////        when(operator) {
////            "+" -> return numberFirstMonkey.number + numberSecondMonkey.number
////            "-" -> return numberFirstMonkey.number + numberSecondMonkey.number
////            "*" -> return numberFirstMonkey.number + numberSecondMonkey.number
////            "/" -> return numberFirstMonkey.number + numberSecondMonkey.number
////        }
////
////        return -1
////    }
////    else if (firstMonkey.second is Monkey.OperatorMonkey && secondMonkey.second is Monkey.NumberMonkey){
////        return
////    }
////    else if (firstMonkey.second is Monkey.NumberMonkey && secondMonkey.second is Monkey.OperatorMonkey){
////
////    } else {
////
////    }
////
////    return -1
////}
//
//
////fun getMonkey(t: String): Pair<String, Monkey> {
////    val s = t.split(" ")
////    val monkey = s[0].substringBefore(":")
////    return if (t.contains(Regex("""[+-/*]"""))) {
////
////        val firstMonkey = s[1]
////        val operator = s[2]
////        val secondMonkey = s[3]
////        monkey to Monkey.OperatorMonkey(monkey, operator, firstMonkey, secondMonkey)
////    } else {
////        monkey to Monkey.NumberMonkey(monkey = monkey, number = s[1].toLong() )
////    }
////}
////
////sealed class Monkey(open val monkey: String) {
////    data class OperatorMonkey(override val monkey: String, val operator: String, val firstMonkey: String, val secondMonkey: String):Monkey()
////
////    data class NumberMonkey(override val monkey: String, val number: Long): Monkey()
////}
////
