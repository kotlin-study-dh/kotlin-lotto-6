package lotto.view

object InputView {

    fun readPriceToBuy(): String {
        println("Please enter the purchase amount.")
        return readln()
    }

    fun readWinningNumbers(): String {
        println("Please enter the winning numbers.")
        return readln()
    }

    fun readBonusNumber(): String {
        println("Please enter the bonus number.")
        return readln()
    }
}
