package lotto.ui

private const val DEFAULT_DELIMITER = ","

object InputView {
    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val purchaseAmount = readlnOrNull() ?: throw IllegalArgumentException("You need to enter a purchase amount.")
        println()
        return purchaseAmount.toIntOrNull() ?: throw IllegalArgumentException("Purchase amount must be a number.")
    }

    fun readWinningNumbers(): List<Int> {
        println("당첨 번호를 입력해 주세요.")
        val winningNumbers = readlnOrNull() ?: throw IllegalArgumentException("You need to enter winner numbers.")
        println()
        return winningNumbers.split(DEFAULT_DELIMITER)
            .map { it.trim() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("Winning numbers must be numbers.") }
    }

    fun readBonusNumber(): Int {
        println("보너스 번호를 입력해 주세요.")
        val bonusNumber = readlnOrNull() ?: throw IllegalArgumentException("You need to enter a bonus number.")
        println()
        return bonusNumber.toIntOrNull() ?: throw IllegalArgumentException("Bonus number must be a number.")
    }
}
