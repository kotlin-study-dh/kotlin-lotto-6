package lotto.view

import lotto.domain.Lottos
import lotto.domain.Prize
import java.text.DecimalFormat

class OutputView {

    fun printGeneratedLottos(lottos: Lottos) {
        println("${lottos.items.size}개를 구매했습니다.")
        lottos.items.forEach { it ->
            val sorted = it.lottoNumbers.map { it.number }.sorted()
            println("[${sorted.joinToString(", ")}]")
        }
    }

    fun printWinningStatistics(prizes: List<Prize>) {
        val prizeToCount = Prize.entries.sortedBy { it.shouldMatchedAtLeast }
            .associateWith { prize -> prizes.count { it == prize } }
        println("당첨 통계")
        println("---")

        prizeToCount.forEach { prize, count ->
            println(
                "${prize.shouldMatchedAtLeast}개 일치${if (prize.shouldBonusMatch)", 보너스 볼 일치" else ""} (${
                    String.format(
                        "%,d",
                        prize.reward
                    )
                }원) - ${count}개"
            )
        }
    }

    fun printRevenue(revenue: Double) {
        val formattedRevenue = DecimalFormat("#,###.#").format(revenue)
        println("총 수익률은 ${formattedRevenue}%입니다.")
    }

}