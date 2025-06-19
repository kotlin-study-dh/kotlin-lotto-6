package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class Lottos(items: List<Lotto>) {
    val items: List<Lotto> = items.toList()

    fun checkWinningResult(winningNumbers: List<LottoNumber>, bonusNumber: LottoNumber): LottoResult {
        val prizes = items.mapNotNull { lotto ->
            val matchedCount = lotto.match(winningNumbers)
            val containsBonus = lotto.contains(bonusNumber)
            Prize.of(matchedCount, containsBonus)
        }
        return LottoResult.of(prizes, LottoPurchaseAmount.from(items.size))
    }


    companion object {
        fun from(lottoCount: Int): Lottos {
            val lottos = (1..lottoCount).map { generateLotto() }
            return Lottos(lottos)
        }

        private fun generateLotto(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(
                LottoNumber.MIN_VALUE,
                LottoNumber.MAX_VALUE,
                Lotto.SIZE_OF_LOTTO_NUMBERS
            )
            return Lotto(numbers)
        }
    }
}