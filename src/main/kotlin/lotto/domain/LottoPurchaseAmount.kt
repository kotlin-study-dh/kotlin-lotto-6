package lotto.domain

data class LottoPurchaseAmount(val value: Int) {
    val lottoAmount: Int
        get() = value / PURCHASE_AMOUNT_UNIT

    init {
        require(value % PURCHASE_AMOUNT_UNIT == 0) { "Lotto purchase amount must be a multiple of $PURCHASE_AMOUNT_UNIT" }
        require(value > 0) { "Lotto purchase amount must be greater than zero" }

    }

    companion object {
        const val PURCHASE_AMOUNT_UNIT = 1_000

        fun from(lottoCount: Int) = LottoPurchaseAmount(lottoCount * PURCHASE_AMOUNT_UNIT)
    }
}
