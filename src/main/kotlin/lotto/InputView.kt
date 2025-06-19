package lotto

import camp.nextstep.edu.missionutils.Console

fun readPurchaseAmount(): Int {
    println("구입금액을 입력해 주세요.")
    return Console.readLine().toInt()
}

fun readWinningNumbers(): List<Int> {
    println("당첨 번호를 입력해 주세요.")
    return Console.readLine()
        .split(",")
        .filter { it.isNotBlank() }
        .map { it.toInt() }
}

fun readBonusNumber(): Int {
    println("보너스 번호를 입력해 주세요.")
    return Console.readLine().toInt()
}
