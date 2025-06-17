package lotto.domain

class Lotto(
    private val numbers: List<LottoNumber>,
) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT) {
            "A Lotto must contain exactly $LOTTO_NUMBER_COUNT numbers."
        }
        require(numbers.distinct().size == numbers.size) {
            "Lotto numbers must be unique."
        }
    }

    fun getSortedNumbers(): List<LottoNumber> = numbers.sortedBy { it.number }

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
