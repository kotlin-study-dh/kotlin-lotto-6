package lotto.input

class ConsoleInput {

    fun purchaseRequest(): Int {
        println("Please enter the purchase amount.")
        return readLine()!!.toInt()
    }

    fun winningNumberRequest(): List<Int> {
        println("Please enter the winning numbers.")
        return readLine()!!.split(",").map { it.toInt() }
    }

    fun bonusNumberRequest(): Int {
        println("Please enter the bonus number.")
        return readLine()!!.toInt()
    }
}