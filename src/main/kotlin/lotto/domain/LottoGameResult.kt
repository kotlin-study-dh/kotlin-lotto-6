package lotto.domain

class LottoGameResult(
    ranks: List<LottoRank>
) {
    val rankCounts: MutableMap<LottoRank, Int> = LottoRank.entries
        .associateWith { 0 }
        .toMutableMap()

    init {
        ranks.forEach { rank ->
            rankCounts[rank] = (rankCounts[rank] ?: 0) + 1
        }
    }

    fun prizeMoney(): Long {
        return rankCounts.entries.sumOf { (rank, count) -> rank.prizeMoney * count }
    }
}
