package lotto.domain

open class Number(val number: Int) {

    companion object {
        const val MIN_LIMIT_NUMBER = 1
        const val MAX_LIMIT_NUMBER = 45
    }

    init {
        if (number !in MIN_LIMIT_NUMBER..MAX_LIMIT_NUMBER) {
            throw IllegalArgumentException("The number must be between $MIN_LIMIT_NUMBER and $MAX_LIMIT_NUMBER")
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Number

        return number == other.number
    }

    override fun hashCode(): Int {
        return number
    }
}