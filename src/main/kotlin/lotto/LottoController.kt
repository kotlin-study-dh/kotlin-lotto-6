package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Lotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(val input: InputView, val output: OutputView) {

    fun run() {
        // 1. 로또 구입 금액 입력
        val purchaseAmount = input.readPurchaseAmount()

        // 2. 금액에 해당하는 로또 갯수 구하기
        if (purchaseAmount % PURCHASE_AMOUNT_UNIT != 0) {
            throw IllegalArgumentException("purchase amount has to be divided by 1000.")
        }
        val lottoCount = purchaseAmount / PURCHASE_AMOUNT_UNIT

        // 3. 로또 발행 후 보관 -> 갯수만큼 반복

        // 4. 당첨번호, 보너스 번호 입력받기

        // 5. 로또, 당첨번호 비교

        // 6. 당첨 내역 및 수익률 계산 / 출력
    }
}