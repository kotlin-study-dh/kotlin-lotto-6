package lotto.domain

data class LottoResult(val prizes: List<Prize>, val revenue: Double) {
    companion object {
        fun of(prizes: List<Prize>, purchaseAmount: LottoPurchaseAmount): LottoResult {
            val totalReward = prizes.sumOf { it.reward }
            val revenue = totalReward.toDouble() / purchaseAmount.value
            return LottoResult(prizes, revenue)
        }
    }
}
