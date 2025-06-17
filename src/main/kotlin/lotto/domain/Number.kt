package lotto.domain

class Number(val number: Int) {

    companion object {
        const val MIN_LIMIT_NUMBER = 1
        const val MAX_LIMIT_NUMBER = 45
    }

    init {
        if (number !in MIN_LIMIT_NUMBER..MAX_LIMIT_NUMBER) {
            throw IllegalArgumentException("The number must be between $MIN_LIMIT_NUMBER and $MAX_LIMIT_NUMBER")
        }
    }
}