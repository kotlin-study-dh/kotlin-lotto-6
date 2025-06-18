package lotto.domain

class LottoExchanger {

    companion object {
        const val PURCHASE_AMOUNT_PER_CASE = 1_000
    }

    fun purchase(amount: Int): Int {
        require(amount % PURCHASE_AMOUNT_PER_CASE == 0) {
            throw IllegalArgumentException("Invalid amount: $amount")
        }
        return amount / PURCHASE_AMOUNT_PER_CASE
    }
}