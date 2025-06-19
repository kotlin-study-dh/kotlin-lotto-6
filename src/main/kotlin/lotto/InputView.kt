package lotto

import camp.nextstep.edu.missionutils.Console

fun readPurchaseAmount(): Int {
    println("구입금액을 입력해 주세요.")
    val amount = Console.readLine().toInt()

    require((amount % 1000) == 0) {
        "[ERROR] Purchase amount must be unit of 1000won"
    }
    return amount / 1000
}

fun readWinningNumbers(): List<Int> {
    println("\n당첨 번호를 입력해 주세요.")
    return Console.readLine()
        .split(",")
        .filter { it.isNotBlank() }
        .map { it.toInt() }
}

fun readBonusNumber(): Int {
    println("\n보너스 번호를 입력해 주세요.")
    return Console.readLine().toInt()
}
