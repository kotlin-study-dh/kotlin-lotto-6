package lotto.ui

private const val DEFAULT_DELIMITER = ","

object InputView {
    fun readPurchaseAmount(): Int {
        println("Please enter a purchase amount")
        val purchaseAmount = readlnOrNull()?: throw IllegalArgumentException("You need to enter a purchase amount.")
        return purchaseAmount.toIntOrNull() ?: throw IllegalArgumentException("Purchase amount must be a number.")
    }

    fun readWinningNumbers(): List<String> {
        println("Please enter winner numbers.")
        val winningNumbers = readlnOrNull()?: throw IllegalArgumentException("You need to enter winner numbers.")
        return winningNumbers.split(DEFAULT_DELIMITER).map { it.trim() }
    }

    fun readBonusNumber(): Int {
        println("Please enter a bonus number.")
        val bonusNumber = readlnOrNull()?: throw IllegalArgumentException("You need to enter a bonus number.")
        return bonusNumber.toIntOrNull() ?: throw IllegalArgumentException("Bonus number must be a number.")
    }
}
