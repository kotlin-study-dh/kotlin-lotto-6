package lotto

fun printPurchaseAmount(lottos: List<Lotto>) {
    println("\n${lottos.size}개를 구매했습니다.")
    lottos.forEach { println(it.numbers) }
}

fun printWinningStatus(winningResult: WinningResult, purchaseAmount: Int) {
    val winningStatus = """
        
        당첨 통계
        ---
        3개 일치 (5,000원) - ${winningResult.getByRank(LottoRank.THREE_MATCH)}개
        4개 일치 (50,000원) - ${winningResult.getByRank(LottoRank.FOUR_MATCH)}개
        5개 일치 (1,500,000원) - ${winningResult.getByRank(LottoRank.FIVE_MATCH)}개
        5개 일치, 보너스 볼 일치 (30,000,000원) - ${winningResult.getByRank(LottoRank.FIVE_BONUS_MATCH)}개
        6개 일치 (2,000,000,000원) - ${winningResult.getByRank(LottoRank.SIX_MATCH)}개
        총 수익률은 ${winningResult.calculateProfitRate(purchaseAmount)}%입니다.
    """.trimIndent()
    print(winningStatus)
}
