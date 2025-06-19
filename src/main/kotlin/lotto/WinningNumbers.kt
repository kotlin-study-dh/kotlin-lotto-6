package lotto

data class WinningNumbers(
    val numbers: LottoNumbers,
    val bonusNumber: Int
) {
    init {
        require(numbers.isContain(bonusNumber))
    }
}
