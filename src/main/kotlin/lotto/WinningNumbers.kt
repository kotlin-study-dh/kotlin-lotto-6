package lotto

data class WinningNumbers(
    val numbers: Lotto,
    val bonusNumber: Int
) {
    init {
        require(!numbers.isContain(bonusNumber)) {
            "[ERROR] LottoNumbers and bonusNumber are duplicated"
        }
    }
}
