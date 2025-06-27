package lotto.domain

class LottoNumber private constructor(
    val number: Int,
) {
    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        private val lottoNumberCache: Map<Int, LottoNumber> =
            (MIN_NUMBER..MAX_NUMBER).associateWith { LottoNumber(it) }

        fun from(number: Int): LottoNumber {
            return lottoNumberCache[number]
                ?: throw IllegalArgumentException("Lotto number must be between $MIN_NUMBER and $MAX_NUMBER.");
        }
    }
}
