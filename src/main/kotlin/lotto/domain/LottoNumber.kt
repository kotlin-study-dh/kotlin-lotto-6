package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in MIN_VALUE..MAX_VALUE) { "Lotto number must be between $MIN_VALUE and $MAX_VALUE." }
    }

    companion object {
        const val MIN_VALUE = 1
        const val MAX_VALUE = 45
    }
}