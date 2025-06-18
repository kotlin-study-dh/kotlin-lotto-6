package lotto.domain

class LottoExchanger(val purchaseAmount: Int) {

    init {
        require(purchaseAmount % PURCHASE_AMOUNT_PER_CASE == 0) {
            throw IllegalArgumentException("Invalid amount: $purchaseAmount")
        }
    }

    companion object {
        const val PURCHASE_AMOUNT_PER_CASE = 1_000
    }

    fun purchase(): Int {
        return purchaseAmount / PURCHASE_AMOUNT_PER_CASE
    }

    fun yieldRate(scores: List<Score>): Int {
        val totalProfit = scores.map { it -> it.prize }
            .reduce { acc, score -> acc + score }
        return totalProfit / purchaseAmount
    }
}