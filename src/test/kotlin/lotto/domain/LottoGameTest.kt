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
                Lotto.ofNumbers(1, 2, 3, 4, 5, 6),
                Lotto.ofNumbers(11, 12, 13, 14, 15, 16),
                Lotto.ofNumbers(21, 22, 23, 24, 25, 26),
            )
        )
    }

    @Test
    fun `throw error when bonus number and winning number duplication`() {
        assertThrows<IllegalArgumentException>("There must be no duplication between winning numbers and bonus number") {
            LottoGame(
                validLottos,
                WinningNumbers.ofNumbers(listOf(1, 2, 3, 4, 5, 6)),
                LottoNumber(1)
            )
        }
    }

    @Test
    fun `throw exception when winning number has invalid size`() {
        assertThrows<IllegalArgumentException>("There must be ${LottoConstants.NUMBERS_AMOUNT} winning numbers.") {
            LottoGame(validLottos, WinningNumbers.ofNumbers(listOf(1, 2, 3, 4, 5)), LottoNumber(45))
        }

        assertThrows<IllegalArgumentException>("There must be ${LottoConstants.NUMBERS_AMOUNT} winning numbers.") {
            LottoGame(validLottos, WinningNumbers.ofNumbers(listOf(1, 2, 3, 4, 5, 6, 7)), LottoNumber(45))
        }
    }

    @ParameterizedTest
    @ValueSource(ints = [LottoConstants.MIN_NUMBER - 1, LottoConstants.MAX_NUMBER + 1])
    fun `throw exception when bonus number is in invalid range`(bonusNumber: Int) {
        assertThrows<IllegalArgumentException>("Bonus number must be between ${LottoConstants.MIN_NUMBER} and ${LottoConstants.MAX_NUMBER}.") {
            LottoGame(validLottos, WinningNumbers.ofNumbers(listOf(1, 2, 3, 4, 5, 6)), LottoNumber(bonusNumber))
        }
    }

    @Test
    fun `get the overall result for all the lottos`() {
        // given
        val lottos = Lottos(
            listOf(
                Lotto.ofNumbers(1, 2, 3, 4, 5, 6), // 1st
                Lotto.ofNumbers(1, 2, 3, 4, 5, 6), // 1st
                Lotto.ofNumbers(1, 2, 3, 4, 5, 45), // 2nd
                Lotto.ofNumbers(1, 2, 3, 4, 5, 16), // 3rd
                Lotto.ofNumbers(1, 2, 3, 14, 15, 16), // 5th
                Lotto.ofNumbers(11, 12, 13, 14, 15, 16), // no-prize
            )
        )

        val winningNumbers = WinningNumbers.ofNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = LottoNumber(45)
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
