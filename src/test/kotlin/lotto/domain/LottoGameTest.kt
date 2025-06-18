package lotto.domain

import lotto.constant.LottoConstants
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoGameTest {

    companion object {
        val validLottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(11, 12, 13, 14, 15, 16)),
                Lotto(listOf(21, 22, 23, 24, 25, 26)),
            )
        )
    }

    @Test
    fun `throw exception when winning number has invalid size`() {
        assertThrows<IllegalArgumentException>("There must be ${LottoConstants.NUMBERS_AMOUNT} winning numbers.") {
            LottoGame(validLottos, listOf(1, 2, 3, 4, 5), 45)
        }

        assertThrows<IllegalArgumentException>("There must be ${LottoConstants.NUMBERS_AMOUNT} winning numbers.") {
            LottoGame(validLottos, listOf(1, 2, 3, 4, 5, 6, 7), 45)
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [LottoConstants.MIN_NUMBER - 1, LottoConstants.MAX_NUMBER + 1])
    fun `throw exception when bonus number is in invalid range`(bonusNumber: Int) {
        assertThrows<IllegalArgumentException>("Bonus number must be between ${LottoConstants.MIN_NUMBER} and ${LottoConstants.MAX_NUMBER}.") {
            LottoGame(validLottos, listOf(1, 2, 3, 4, 5, 6), bonusNumber)
        }
    }

    @Test
    fun `get the overall result for all the lottos`() {
        // given
        val lottos = Lottos(
            listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)), // 1st
                Lotto(listOf(1, 2, 3, 4, 5, 6)), // 1st
                Lotto(listOf(1, 2, 3, 4, 5, 45)), // 2nd
                Lotto(listOf(1, 2, 3, 4, 5, 16)), // 3rd
                Lotto(listOf(1, 2, 3, 14, 15, 16)), // 5th
                Lotto(listOf(11, 12, 13, 14, 15, 16)), // no-prize
            )
        )

        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = 45
        val lottoGame = LottoGame(lottos, winningNumbers, bonusNumber)

        // when
        val result = lottoGame.result()

        // then
        assert(
            result == mapOf(
                LottoRank.FIRST to 2,
                LottoRank.SECOND to 1,
                LottoRank.THIRD to 1,
                LottoRank.FIFTH to 1,
                LottoRank.NO_PRIZE to 1,
            )
        )
    }
}
