package lotto.domain

data class Lotto(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            "Lotto must have six numbers"
        }
        require(numbers.size == numbers.toSet().size) {
            "Lotto has duplicate number"
        }
        for (number in numbers) {
            require(number >= 1 && number <= 45) {
                "Lotto number must be between 1 and 45"
            }
        }
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }

    fun isContain(number: Int): Boolean {
        return numbers.contains(number)
    }
}
