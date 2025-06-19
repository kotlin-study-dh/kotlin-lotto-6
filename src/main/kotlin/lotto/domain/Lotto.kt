package lotto.domain

class Lotto(numbers: List<Int>) {
    private val _lottoNumbers: List<LottoNumber> = numbers.map { LottoNumber(it) }
    val lottoNumbers: List<LottoNumber>
        get() = _lottoNumbers.toList()


    init {
        require(numbers.size == SIZE_OF_LOTTO_NUMBERS) { "The number of lotto numbers must be $SIZE_OF_LOTTO_NUMBERS." }
        require(numbers.distinct().size == SIZE_OF_LOTTO_NUMBERS) { "Lotto numbers must be unique." }
    }

    fun match(winningNumbers: List<LottoNumber>): Int = _lottoNumbers.count { winningNumbers.contains(it) }

    fun contains(number: LottoNumber): Boolean = _lottoNumbers.contains(number)

    companion object {
        const val SIZE_OF_LOTTO_NUMBERS = 6
    }

}