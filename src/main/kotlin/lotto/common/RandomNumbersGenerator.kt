package lotto.common

object RandomNumbersGenerator {

    fun generate(from: Int, to: Int, amount: Int): List<Int> {
        return (from..to).toMutableList()
            .also { it.shuffle() }
            .take(amount)
            .sorted()
    }
}
