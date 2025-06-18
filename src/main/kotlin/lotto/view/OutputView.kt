package lotto.view

import lotto.domain.Lottos

object OutputView {

    fun printLottoNumbers(lottos: Lottos) {
        println("You have bought ${lottos.size()} lotto(s)")

        lottos.getElements().forEach {
            println(it.getNumbers())
        }
    }
}
