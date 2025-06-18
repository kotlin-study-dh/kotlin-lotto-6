package lotto.domain

enum class Score(private val matchRule: (Int, Boolean) -> Boolean) {

    FIRST({ winningMatch, bonus -> winningMatch == 6 }),
    SECOND({ winningMatch, bonus -> winningMatch == 5 && bonus }),
    THIRD({ winningMatch, bonus -> winningMatch == 5 && !bonus }),
    FOURTH({ winningMatch, bonus -> winningMatch == 4 }),
    FIFTH({ winningMatch, bonus -> winningMatch == 3 }),
    NO_WAY({ winningMatch, bonus -> winningMatch < 3 });

    companion object {
        fun from(winningMatches: Int, bonusMatch: Boolean): Score {
            return entries.find {
                it.matchRule(winningMatches, bonusMatch)
            } ?: throw IllegalArgumentException("Winning $winningMatches and Bonus: $bonusMatch not found")
        }
    }
}