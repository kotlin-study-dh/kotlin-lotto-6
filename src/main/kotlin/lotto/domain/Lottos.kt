package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class Lottos(items: List<Lotto>) {
    val items: List<Lotto> = items.toList()

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