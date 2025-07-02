package lotto.domain

import lotto.domain.number.Numbers
import lotto.domain.number.RandomNumberGenerator

class LottoExchanger(val purchaseAmount: Int) {

    init {
        require(purchaseAmount % PURCHASE_AMOUNT_PER_CASE == 0) {
            throw IllegalArgumentException("Invalid amount: $purchaseAmount")
        }
        require(purchaseAmount > 0) {
            throw IllegalArgumentException("Invalid purchase amount: $purchaseAmount")
        }
    }

    companion object {
        const val PURCHASE_AMOUNT_PER_CASE = 1_000
    }

    fun purchase(): List<Numbers> {
        val ticketSize = purchaseAmount / PURCHASE_AMOUNT_PER_CASE
        val randomNumberGenerator = RandomNumberGenerator()
        return List(ticketSize) {
            val issuer = LottoIssuer(randomNumberGenerator)
            issuer.issue()
        }
    }

    fun yieldRate(scores: List<Score>): Double {
        val totalProfit = scores.map { it -> it.prize }
            .reduce { acc, score -> acc + score }
        return (totalProfit / purchaseAmount.toDouble()) * 100
    }
}