package lotto.ui

import lotto.domain.Lotto
import lotto.domain.Prize
import java.text.DecimalFormat

private const val DEFAULT_SEPARATOR = ", "
private const val PREFIX = "["
private const val POSTFIX = "]"
private const val ERROR_PREFIX = "[ERROR]"

object OutputView {
    private val numberFormatter = DecimalFormat("#,###")

    fun printLottos(lottos: List<Lotto>) {
        println(System.lineSeparator() + "${lottos.size}개를 구매했습니다.")
        lottos.forEach {
            println(it.getSortedNumbers().map { lottoNumber -> lottoNumber.number }
                .joinToString(separator = DEFAULT_SEPARATOR, prefix = PREFIX, postfix = POSTFIX))
        }
    }

    fun printWinningStatistics(prizeCounts: Map<Prize, Int>) {
        println(System.lineSeparator() + "당첨 통계")
        println("---")
        prizeCounts.filter { Prize.NONE != it.key }
            .forEach { (prize, count) -> println(formatPrizeResult(prize, count)) }
    }

    private fun formatPrizeResult(prize: Prize, count: Int): String {
        val formattedWinningAmount = numberFormatter.format(prize.winningAmount)
        if (prize == Prize.SECOND) {
            return "${prize.matchCount}개 일치, 보너스 볼 일치 (${formattedWinningAmount}원) - ${count}개"
        }
        return "${prize.matchCount}개 일치 (${formattedWinningAmount}원) - ${count}개"
    }

    fun printRateOfReturn(rateOfReturn: Double) {
        println("총 수익률은 ${rateOfReturn}%입니다.")
    }
}
