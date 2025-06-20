package lotto.domain

data class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) {
            "Lotto must have six numbers"
        }
        require(numbers.size == numbers.toSet().size) {
            "Lotto has duplicate number"
        }
        for (number in numbers) {
            require(number >= LOTTO_MIN_NUMBER && number <= LOTTO_MAX_NUMBER) {
                "Lotto number must be between 1 and 45"
            }
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
