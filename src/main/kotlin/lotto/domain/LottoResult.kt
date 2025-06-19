package lotto.domain

data class LottoResult(val prizes: List<Prize>, val revenue: Double) {
    companion object {
        fun of(prizes: List<Prize>, purchaseAmount: LottoPurchaseAmount): LottoResult {
            val totalReward = prizes.sumOf { it.reward }
            val revenue = calculateRevenueInPercent(totalReward, purchaseAmount)
            return LottoResult(prizes, revenue)
        }

        private fun calculateRevenueInPercent(totalReward: Long, purchaseAmount: LottoPurchaseAmount): Double =
            totalReward.toDouble() / purchaseAmount.value * 100
    }
}
