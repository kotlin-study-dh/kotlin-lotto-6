package lotto.domain.number

interface NumberGenerator {

    fun generate(count: Int): IntArray
}