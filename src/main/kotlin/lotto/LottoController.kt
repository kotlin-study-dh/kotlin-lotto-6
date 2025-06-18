package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Lotto
import lotto.domain.Prize
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
        val lottos = mutableListOf<Lotto>()
        repeat(lottoCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottos.add(Lotto(numbers))
        }

        // 4. 당첨번호, 보너스 번호 입력받기
        val winningNumbers = input.readWinningNumbers()
        val bonusNumber = input.readBonusNumber()

        val prizes = lottos.map { it.match(winningNumbers) }
                .mapNotNull { Prize.of(it, winningNumbers.contains(bonusNumber)) }

        val totalReward = prizes.sumOf { it.reward }
        val revenue = totalReward.toDouble() / purchaseAmount * 100
    }

    companion object {
        const val PURCHASE_AMOUNT_UNIT = 1_000
    }
}