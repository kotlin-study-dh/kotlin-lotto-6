package lotto.domain

data class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) {
            "Lotto must have six numbers"
        }
        require(numbers.size == numbers.toSet().size) {
            "Lotto has duplicate number"
        }
        require(numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }) {
            "Lotto number must be between $LOTTO_MIN_NUMBER and $LOTTO_MAX_NUMBER"
        }
    }

    companion object {
        const val LOTTO_SIZE = 6
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        const val LOTTO_PRICE = 1_000
    }

    fun isContain(number: Int): Boolean {
        return numbers.contains(number)
    }
}
