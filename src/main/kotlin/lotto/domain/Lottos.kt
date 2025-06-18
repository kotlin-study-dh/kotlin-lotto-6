package lotto.domain

class Lottos(private val elements: List<Lotto>) {

    constructor(issueAmount: Int) : this(
        List(issueAmount) { Lotto() }
    )

    fun size() = elements.size

    fun result(winningNumbers: List<Int>, bonusNumber: Int): Map<LottoRank, Int> {
        return elements.map { it.calculateRank(winningNumbers, bonusNumber) }
            .groupingBy { it }
            .eachCount()
    }

    fun getElements() = elements
}
