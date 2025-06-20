package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.Lotto

fun readPurchaseAmount(): Int {
    println("구입금액을 입력해 주세요.")
    val amount = (Console.readLine().toIntOrNull()
        ?: throw IllegalArgumentException("Purchase amount must be natural number"))
    require((amount % Lotto.LOTTO_PRICE) == 0) {
        "Purchase amount must be unit of 1000won"
    }
    require(amount > 0) {
        "Purchase amount must be at least 1000won"
    }

    return amount / Lotto.LOTTO_PRICE
}

fun readWinningNumbers(): List<Int> {
    println("\n당첨 번호를 입력해 주세요.")
    return Console.readLine().replace(" ", "").split(",")
        .map {
            it.toIntOrNull()
                ?: throw IllegalArgumentException("Purchase amount must be natural number")
        }
}

fun readBonusNumber(): Int {
    println("\n보너스 번호를 입력해 주세요.")

    return (Console.readLine().toIntOrNull()?.let { bonusNumber ->
        require(bonusNumber in Lotto.LOTTO_MIN_NUMBER..Lotto.LOTTO_MAX_NUMBER) {
            "Bonus number must be must be between 1 and 45"
        }
        bonusNumber
    } ?: throw IllegalArgumentException("Purchase amount must be natural number"))
}
