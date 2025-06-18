package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { "Lotto number must be between 1 and 45." }
    }
}