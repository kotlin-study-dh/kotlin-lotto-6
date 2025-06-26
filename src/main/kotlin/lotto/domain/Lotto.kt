package lotto.domain

class Lotto(private val lottoNumbers: List<LottoNumber>) {

    init {
        require(lottoNumbers.size == SIZE_OF_LOTTO_NUMBERS) { "The number of lotto numbers must be $SIZE_OF_LOTTO_NUMBERS." }
        require(lottoNumbers.distinct().size == lottoNumbers.size) { "Lotto numbers must be unique." }
    }

    fun match(winningNumbers: List<LottoNumber>): Int = lottoNumbers.count { winningNumbers.contains(it) }

    fun contains(number: LottoNumber): Boolean = lottoNumbers.contains(number)

    fun getNumbers() = lottoNumbers.map { it.number }

    companion object {
        const val SIZE_OF_LOTTO_NUMBERS = 6

        fun from(numbers: List<Int>) = Lotto(numbers.map { LottoNumber(it) })
    }

}