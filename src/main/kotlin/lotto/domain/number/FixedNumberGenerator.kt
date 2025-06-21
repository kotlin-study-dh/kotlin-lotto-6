package lotto.domain.number

class FixedNumberGenerator : NumberGenerator {

    override fun generate(count: Int): IntArray {
        return IntArray(count) { it + 1 }
    }
}