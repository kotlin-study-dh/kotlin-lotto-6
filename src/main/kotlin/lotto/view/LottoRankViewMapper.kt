package lotto.view

import lotto.domain.LottoRank
import lotto.domain.LottoRank.*

object LottoRankViewMapper {

    fun toText(lottoRank: LottoRank): String = when (lottoRank) {
        FIRST -> "${FIRST.matchCount} matches (${FIRST.prizeMoney} KRW)"
        SECOND -> "${SECOND.matchCount} matches (${SECOND.prizeMoney} KRW)"
        THIRD -> "${THIRD.matchCount} matches (${THIRD.prizeMoney} KRW)"
        FOURTH -> "${FOURTH.matchCount} matches (${FOURTH.prizeMoney} KRW)"
        FIFTH -> "${FIFTH.matchCount} matches (${FIFTH.prizeMoney} KRW)"
        NO_PRIZE -> "${NO_PRIZE.matchCount} matches (${NO_PRIZE.prizeMoney}) KRW"
    }
}
