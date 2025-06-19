package lotto.common

object MoneyCalculator {

    fun calculateRateOfReturn(purchasedMoney: Long, earnedMoney: Long): Double {
        return earnedMoney.toDouble() / purchasedMoney.toDouble() * 100.0
    }
}
