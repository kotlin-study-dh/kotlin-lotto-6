package lotto.domain

class Lotto(numbers: List<Int>) {
    private val lottoNumbers: List<LottoNumber> = numbers.map { LottoNumber(it) }

    init {
        require(numbers.size == SIZE_OF_LOTTO_NUMBERS) { "The number of lotto numbers must be $SIZE_OF_LOTTO_NUMBERS." }
        require(numbers.distinct().size == SIZE_OF_LOTTO_NUMBERS) { "Lotto numbers must be unique." }
    }

    companion object {
        const val SIZE_OF_LOTTO_NUMBERS = 6
    }

}