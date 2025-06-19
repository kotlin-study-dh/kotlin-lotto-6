package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoNumbersGenerator {

    fun generate() : List<Int> = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
}
