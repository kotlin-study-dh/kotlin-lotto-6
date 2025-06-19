package lotto.domain

class LottoGameResult(
    private val counts: MutableMap<LottoRank, Int> = LottoRank.entries
        .associateWith { 0 }
        .toMutableMap()
) {

    fun addRank(rank: LottoRank) {
        counts[rank] = counts[rank]!! + 1
    }

    fun prizeMoney(): Long {
        return counts.entries.sumOf { (rank, count) -> rank.prizeMoney * count }
    }

    fun getResult(): Map<LottoRank, Int> {
        return counts
    }
}
