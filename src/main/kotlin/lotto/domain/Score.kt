package lotto.domain

enum class Score(val winningMatches: Int, val bonusMatch: Boolean, private val matchRule: (Int, Boolean) -> Boolean) {

    FIRST(6, false, { winningMatch, bonus -> winningMatch == 6 }),
    SECOND(5, true, { winningMatch, bonus -> winningMatch == 6 && bonus }),
    THIRD(5, false, { winningMatch, bonus -> winningMatch == 5 }),
    FOURTH(4, false, { winningMatch, bonus -> winningMatch == 4 }),
    FIFTH(3, false, { winningMatch, bonus -> winningMatch == 3 });


    companion object {
        fun from(winningMatches: Int, bonusMatch: Boolean): Score {
            return entries.find {
                it.matchRule(winningMatches, bonusMatch)
            } ?: throw IllegalArgumentException("Winning $winningMatches and Bonus: $bonusMatch not found")
        }
    }
}