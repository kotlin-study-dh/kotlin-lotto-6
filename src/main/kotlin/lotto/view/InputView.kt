package lotto.view

object InputView {

    fun readPriceToBuy(): String {
        println("Please enter the purchase amount.")
        return readln()
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter the winning numbers.")

        try {
            return readln().split(",")
                .map { it -> it.trim() }
                .map { it -> it.toInt() }
                .toList()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Only integer numbers allowed.")
        }
    }

    fun readBonusNumber(): String {
        println("Please enter the bonus number.")
        return readln()
    }
}
