package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class Lottos(items: List<Lotto>) {
    val items: List<Lotto> = items.toList()

    fun checkWinningResult(winningNumbers: WinningNumbers): LottoResult {
        val (winningLotto, bonusNumber) = winningNumbers
        val prizes = items
            .mapNotNull { lotto ->
                val matchedCount = lotto.match(winningLotto)
                val containsBonus = lotto.contains(bonusNumber)
                Prize.of(matchedCount, containsBonus)
            }
            .filterNot { prize -> prize == Prize.NOTHING }

        return LottoResult.of(prizes, LottoPurchaseAmount.from(items.size))
    }


    companion object {
        fun from(lottoCount: Int): Lottos {
            val lottos = (1..lottoCount).map { generateRandomLotto() }
            return Lottos(lottos)
        }

        private fun generateRandomLotto(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(
                LottoNumber.MIN_VALUE,
                LottoNumber.MAX_VALUE,
                Lotto.SIZE_OF_LOTTO_NUMBERS
            )
            return Lotto.from(numbers)
        }
    }
}