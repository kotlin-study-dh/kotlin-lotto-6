package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.domain.Lotto

object LottoNumbersGenerator {

    fun generate(): List<Int> = Randoms.pickUniqueNumbersInRange(
        Lotto.LOTTO_MIN_NUMBER, Lotto.LOTTO_MAX_NUMBER, Lotto.LOTTO_SIZE
    )
        .sorted()
}
