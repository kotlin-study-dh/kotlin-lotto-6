package lotto.view

object InputView {

    fun readPriceToBuy(): Long {
        println("Please enter the purchase amount.")

        try {
            return readln().toLong()
        } catch (_: NumberFormatException) {
            throw IllegalArgumentException("Only integer numbers allowed.")
        }
    }

    fun readWinningNumbers(): List<Int> {
        println("Please enter the winning numbers.")

        try {
            return readln().split(",")
                .map { it -> it.trim() }
                .map { it -> it.toInt() }
                .toList()
        } catch (_: NumberFormatException) {
            throw IllegalArgumentException("Only integer numbers allowed.")
        }
    }

    fun readBonusNumber(): Int {
        println("Please enter the bonus number.")

        try {
            return readln().toInt()
        } catch (_: NumberFormatException) {
            throw IllegalArgumentException("Only integer number allowed.")
        }
    }
}
