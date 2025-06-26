package lotto.domain

import lotto.domain.Lotto.Companion.SIZE_OF_LOTTO_NUMBERS

data class WinningNumbers(val winningLotto: List<LottoNumber>, val bonusNumber: LottoNumber) {
    init {
        require(winningLotto.size == SIZE_OF_LOTTO_NUMBERS) { "Winning numbers must be $SIZE_OF_LOTTO_NUMBERS" }
        require(winningLotto.distinct().size == winningLotto.size) { "Winning numbers must be unique" }
        require(!winningLotto.contains(bonusNumber)) { "Bonus number must not be in winning numbers" }
    }
}
