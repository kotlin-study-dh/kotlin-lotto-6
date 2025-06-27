package lotto.ui

import camp.nextstep.edu.missionutils.Console

private const val DEFAULT_DELIMITER = ","

object InputView {
    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val purchaseAmount = Console.readLine()
        return purchaseAmount.toIntOrNull() ?: throw IllegalArgumentException("Purchase amount must be a number.")
    }

    fun readWinningNumbers(): List<Int> {
        println(System.lineSeparator() + "당첨 번호를 입력해 주세요.")
        val winningNumbers = Console.readLine()
        return winningNumbers.split(DEFAULT_DELIMITER)
            .map { it.trim() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("Winning numbers must be numbers.") }
    }

    fun readBonusNumber(): Int {
        println(System.lineSeparator() + "보너스 번호를 입력해 주세요.")
        val bonusNumber = Console.readLine()
        return bonusNumber.toIntOrNull() ?: throw IllegalArgumentException("Bonus number must be a number.")
    }
}
