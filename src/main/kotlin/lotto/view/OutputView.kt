package lotto.view

import lotto.common.MoneyCalculator
import lotto.domain.LottoGameResult
import lotto.domain.LottoRank
import lotto.domain.Lottos

object OutputView {

    fun printLottoNumbers(lottos: Lottos) {
        println("You have bought ${lottos.size()} lotto(s)")

        lottos.elements.forEach {
            println(it.getNumbers())
        }
    }

    fun printGameResult(result: LottoGameResult, purchasedPrice: Long) {
        println("Win Status")
        println("---")

        result.rankCounts.entries
            .filter { entry -> entry.key != LottoRank.NO_PRIZE }
            .forEach { (rank, count) ->
                println("${LottoRankViewMapper.toText(rank)} - $count lotto(s)")
            }

        println(
            String.format(
                "Your rate of return is: %.1f%%",
                MoneyCalculator.calculateRateOfReturn(purchasedPrice, result.prizeMoney())
            )
        )
    }
}
