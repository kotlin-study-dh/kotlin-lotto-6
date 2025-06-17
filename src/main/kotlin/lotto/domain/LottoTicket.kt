package lotto.domain

class LottoTicket(
    val lottos: List<Lotto>,
) {

    init {
        require(lottos.isNotEmpty()) { "A LottoTicket must contain at least one Lotto." }
    }

    fun getLottoQuantity(): Int {
        return lottos.size
    }
}
