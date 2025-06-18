package lotto.domain

import lotto.constant.LottoConstants

class WinningNumbers(val numbers: List<Int>) {

    init {
        require(numbers.size == LottoConstants.NUMBERS_AMOUNT) {
            "There must be ${LottoConstants.NUMBERS_AMOUNT} winning numbers."
        }
    }

    fun contains(number: Int) = numbers.contains(number)
}
