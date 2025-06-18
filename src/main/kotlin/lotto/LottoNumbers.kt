package lotto

class LottoNumbers(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {
            "[ERROR] Lotto must have six numbers"
        }
        require(numbers.size == numbers.toSet().size) {
            "[ERROR] Lotto has duplicate number"
        }
        for (number in numbers) {
            require(number >= 1 && number <= 45) {
                "[ERROR] Lotto number must be between 1 and 45"
            }
        }
    }
}
