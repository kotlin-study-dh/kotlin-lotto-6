package lotto.domain

import lotto.constant.LottoConstants

class Lottos(val elements: List<Lotto>) {

    init {
        require(elements.isNotEmpty()) { "At least one lotto has to be bought." }
    }

    companion object {
        fun buy(price: Long): Lottos {
            require(price >= LottoConstants.LOTTO_PRICE) {
                "Purchasing price must be ${LottoConstants.LOTTO_PRICE} or greater."
            }
            require(price % LottoConstants.LOTTO_PRICE == 0L) {
                "Purchasing price must be divisible by ${LottoConstants.LOTTO_PRICE}."
            }

            val buyAmount = (price / LottoConstants.LOTTO_PRICE).toInt()
            return Lottos(List(buyAmount) { Lotto() })
        }
    }

    fun size() = elements.size
}
