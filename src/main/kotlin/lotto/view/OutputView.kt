package lotto.view

import lotto.domain.LottoGame
import lotto.domain.Lottos

object OutputView {

    fun printLottoNumbers(lottos: Lottos) {
        println("You have bought ${lottos.size()} lotto(s)")

        lottos.getElements().forEach {
            println(it.getNumbers())
        }
    }

    fun printGameResult(lottoGame: LottoGame) {
        val result = lottoGame.result()

        result.forEach { (rank, count) ->
            println("${rank.matchCount} matches (won ${rank.prizeMoney} KRW) in $count lotto(s).")
        }
    }
}
