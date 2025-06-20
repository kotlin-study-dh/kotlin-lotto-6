package lotto.domain

import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `should calculate correct revenue with multiple prizes`() {
        // given
        val prizes = listOf(
            Prize.FIFTH,  // 5_000
            Prize.FOURTH, // 50_000
            Prize.SECOND  // 30_000_000
        )
        val purchaseAmount = LottoPurchaseAmount(3_000) // 3 tickets

        // when
        val result = LottoResult.of(prizes, purchaseAmount)

        // then
        val expectedReward = Prize.FIFTH.reward + Prize.FOURTH.reward + Prize.SECOND.reward
        val expectedRevenue = expectedReward.toDouble() / purchaseAmount.value * 100

        assert(result.revenue == expectedRevenue)
        assert(result.prizes == prizes)
    }

    @Test
    fun `should return 0 revenue if there are no winning prizes`() {
        // given
        val prizes = emptyList<Prize>()
        val purchaseAmount = LottoPurchaseAmount(5_000)

        // when
        val result = LottoResult.of(prizes, purchaseAmount)

        // then
        assert(result.revenue == 0.0)
        assert(result.prizes.isEmpty())
    }

    @Test
    fun `should handle single high reward prize correctly`() {
        // given
        val prizes = listOf(Prize.FIRST)
        val purchaseAmount = LottoPurchaseAmount(1_000)

        // when
        val result = LottoResult.of(prizes, purchaseAmount)
        val expectedRevenue = Prize.FIRST.reward.toDouble() / purchaseAmount.value * 100

        // then
        assert(result.revenue == expectedRevenue)
        assert(result.prizes.contains(Prize.FIRST))
    }
}
