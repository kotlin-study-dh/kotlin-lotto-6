package lotto.view

import lotto.domain.Lottos
import lotto.domain.Prize
import java.text.DecimalFormat

class OutputView {

    fun printGeneratedLottos(lottos: Lottos) {
        println("${lottos.items.size}개를 구매했습니다.")
        lottos.items.forEach { println(it.getNumbers().sorted()) }
    }

    fun printWinningStatistics(prizes: List<Prize>) {
        println("당첨 통계")
        println("---")

        val prizeToCount = Prize.entries
            .sortedBy { it.shouldMatchedAtLeast }
            .associateWith { prize -> prizes.count { it == prize } }

        prizeToCount.forEach { (prize, count) ->
            println("${formatPrize(prize)} - ${count}개")
        }
    }

    private fun formatPrize(prize: Prize): String {
        val matchText = "${prize.shouldMatchedAtLeast}개 일치"
        val bonusText = if (prize.shouldBonusMatch) ", 보너스 볼 일치" else ""
        val rewardText = "(${formatReward(prize.reward)}원)"
        return "$matchText$bonusText $rewardText"
    }

    private fun formatReward(reward: Long): String {
        return String.format("%,d", reward)
    }

    fun printRevenue(revenue: Double) {
        val formattedRevenue = DecimalFormat("#,###.#").format(revenue)
        println("총 수익률은 ${formattedRevenue}%입니다.")
    }

}