package lotto.domain

import lotto.constant.LottoConstants

class WinningNumbers(val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == LottoConstants.NUMBERS_AMOUNT) {
            "There must be ${LottoConstants.NUMBERS_AMOUNT} winning numbers."
        }
    }

    companion object {
        fun ofNumbers(numbers: List<Int>): WinningNumbers {
            numbers.map { LottoNumber(it) }
                .toList()
                .also { return WinningNumbers(it) }
        }
    }

    fun contains(number: LottoNumber) = numbers.contains(number)
}
