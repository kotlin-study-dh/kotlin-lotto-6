package lotto.output

import lotto.domain.Score
import lotto.domain.number.Numbers

class ConsoleOutput {

    fun purchaseResponse(tickets: List<Numbers>) {
        println("bought ${tickets.size} of them.")
        tickets.forEach { ticket ->
            ticket.winningNumbers
                .map { it.number }
                .sorted()
                .also { println(it) }
        }
    }

    fun winningStatisticsResponse(prizes: List<Score>) {
        println("Winning Statistics")
        println("3 matches: ${prizes.count { it == Score.FIFTH }}")
        println("4 matches: ${prizes.count { it == Score.FOURTH }}")
        println("5 matches: ${prizes.count { it == Score.THIRD }}")
        println("5 matches & bonus match: ${prizes.count { it == Score.SECOND }}")
        println("6 matches: ${prizes.count { it == Score.FIRST }}")
    }

    fun reteOfReturnResponse(rate: Double) {
        println("total rate of return is $rate%!")
    }
}