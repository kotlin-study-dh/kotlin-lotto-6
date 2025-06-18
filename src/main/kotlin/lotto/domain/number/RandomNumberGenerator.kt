package lotto.domain.number

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator : NumberGenerator {

    override fun generate(count: Int): IntArray {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).toIntArray()
    }
}