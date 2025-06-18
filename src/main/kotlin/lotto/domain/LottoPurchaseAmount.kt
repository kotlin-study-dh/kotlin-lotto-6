package lotto.domain

class LottoPurchaseAmount(
    val amount: Int,
) {
    init {
        require(amount >= LOTTO_PRICE) { "Purchase amount must be equal to or greater than $LOTTO_PRICE." }
        require(amount % LOTTO_PRICE == 0) { "Purchase amount must be a multiple of $LOTTO_PRICE." }
    }

    fun getPurchaseQuantity(): Int {
        return amount / LOTTO_PRICE
    }

    fun calculateRateOfReturn(winningAmount: Int): Double {
        val rateOfReturn = winningAmount.toDouble() / amount * 100
        return roundToFirstDecimal(rateOfReturn)
    }

    private fun roundToFirstDecimal(rateOfReturn: Double) = Math.round(rateOfReturn * 10) / 10.0

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}
