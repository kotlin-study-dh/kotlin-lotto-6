package lotto.domain

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
        return lotto.numbers.count { winningLotto.isContain(it) }
    }

    fun hasBonusNumber(lotto: Lotto) = bonusNumber in lotto.numbers
}
