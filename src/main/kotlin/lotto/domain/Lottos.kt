package lotto.domain

private const val LOTTO_PRICE = 1000

class Lottos(private val elements: List<Lotto>) {

    companion object {
        fun buy(price: Long): Lottos {
            assert(price >= LOTTO_PRICE) { "Purchasing price must be $LOTTO_PRICE or greater." }
            assert(price % LOTTO_PRICE == 0L) { "Purchasing price must be divisible by $LOTTO_PRICE." }

            val buyAmount = (price / LOTTO_PRICE).toInt()
            return Lottos(List(buyAmount) { Lotto() })
        }
    }

    fun size() = elements.size

    fun getElements() = elements
}
