package lotto.ui

import lotto.domain.Lotto
import lotto.domain.Prize

private const val DEFAULT_SEPARATOR = ", "
private const val PREFIX = "["
private const val POSTFIX = "]"

object OutputView {
    fun printLottos(lottos: List<Lotto>) {
        println("You purchased ${lottos.size} lottos.")
        lottos.forEach {
            println(it.getSortedNumbers().map { lottoNumber -> lottoNumber.number }
                .joinToString(separator = DEFAULT_SEPARATOR, prefix = PREFIX, postfix = POSTFIX))
        }
        println()
    }

    fun printWinningStatistics(prizeCounts: Map<Prize, Int>) {
        println("Winning statistics")
        println("---")
        prizeCounts.forEach { (prize, count) ->
            println("${prize.matchCount} matches (${prize.winningAmount}won) - $count win)")
        }
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println("Total profit rate is ${rateOfReturn}%")
    }
}
