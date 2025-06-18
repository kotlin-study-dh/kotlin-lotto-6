package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.LottoNumber

class InputView {
    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return Console.readLine().toInt()
    }

    fun readWinningNumbers(): List<LottoNumber> {
        println("당첨 번호를 입력해 주세요.")
        return Console.readLine().split(",").map { LottoNumber(it.toInt()) }
    }

    fun readBonusNumber(): LottoNumber {
        println("보너스 번호를 입력해 주세요.")
        return LottoNumber(Console.readLine().toInt())
    }
}