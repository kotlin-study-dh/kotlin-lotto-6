package lotto

data class WinningNumbers(
    val winningLotto: Lotto,
    val bonusNumber: Int
) {
    init {
        require(!winningLotto.isContain(bonusNumber)) {
            "LottoNumbers and bonusNumber are duplicated"
        }
    }

    fun calculateMatchingNumber(lotto: Lotto): Int {
        val matchingCnt = lotto.numbers.count { winningLotto.isContain(it) }
        if (lotto.isContain(bonusNumber)) {
            return matchingCnt + 1
        }
        return matchingCnt
    }

    fun hasBonusNumber(lotto: Lotto) = lotto.numbers.contains(bonusNumber)
}
