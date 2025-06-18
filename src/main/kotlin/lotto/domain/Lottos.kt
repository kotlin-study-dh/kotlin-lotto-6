package lotto.domain

class Lottos(private val elements: List<Lotto>) {

    constructor(issueAmount: Int) : this(
        List(issueAmount) { Lotto() }
    )

    fun size() = elements.size

    fun getElements() = elements
}
