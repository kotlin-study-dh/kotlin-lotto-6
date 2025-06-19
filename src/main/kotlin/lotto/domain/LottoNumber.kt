package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in MIN_VALUE..MAX_VALUE) { "Lotto number must be between 1 and 45." }
    }

    companion object {
        const val MIN_VALUE = 1
        const val MAX_VALUE = 45
    }
}