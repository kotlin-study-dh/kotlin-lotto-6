package lotto

import camp.nextstep.edu.missionutils.Console

fun readPurchaseAmount(): Int {
    println("구입금액을 입력해 주세요.")
    val amount = (Console.readLine().toIntOrNull()
        ?: throw IllegalArgumentException("Purchase amount must be natural number"))
    require((amount % 1000) == 0) {
        "Purchase amount must be unit of 1000won"
    }
    require(amount > 0) {
        "Purchase amount must be at least 1000won"
    }

    return amount / 1000
}

fun readWinningNumbers(): List<Int> {
    println("\n당첨 번호를 입력해 주세요.")
    return Console.readLine().split(",")
        .map {
            it.toIntOrNull()
                ?: throw IllegalArgumentException("Purchase amount must be natural number")
        }
}

fun readBonusNumber(): Int {
    println("\n보너스 번호를 입력해 주세요.")
    return (Console.readLine().toIntOrNull()?.let { bonusNumber ->
        require(bonusNumber in 1..45) {
            "Bonus number must be must be between 1 and 45"
        }
        bonusNumber
    } ?: throw IllegalArgumentException("Purchase amount must be natural number"))
}
