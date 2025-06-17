package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class PrizeTest {
    @ParameterizedTest(name = "invalidMatchCount={0}")
    @ValueSource(ints = [-1, 7])
    fun `fails to return Prize when matchCount is less than 0 or greater than 6`(invalidMatchCount: Int) {
        // when & then
        assertThatThrownBy() { Prize.of(invalidMatchCount, false) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Match count must be between 0 and 6.")
    }

    @Test
    fun `returns SECOND when matchCount is 5 and hasBonusNumber is true`() {
        // given
        val matchCount = 5
        val hasBonusNumber = true

        // when
        val prize = Prize.of(matchCount, hasBonusNumber)

        // then
        assertThat(prize).isEqualTo(Prize.SECOND)
    }

    @Test
    fun `returns THIRD when matchCount is 5 and hasBonusNumber is false`() {
        // given
        val matchCount = 5
        val hasBonusNumber = false

        // when
        val prize = Prize.of(matchCount, hasBonusNumber)

        // then
        assertThat(prize).isEqualTo(Prize.THIRD)
    }

    @ParameterizedTest(name = "matchCount={0}")
    @ValueSource(ints = [0, 1, 2])
    fun `returns NONE when matchCount is less than 3, regardless of bonus number`(matchCount: Int) {
        // when
        val prize = Prize.of(matchCount, false)

        // then
        assertThat(prize).isEqualTo(Prize.NONE)
    }

    @ParameterizedTest(name = "matchCount={0}, expectedPrize={1}")
    @CsvSource(
        "3, FIFTH",
        "4, FOURTH",
        "6, FIRST"
    )
    fun `returns correct Prize based on matchCount, regardless of bonus number`(matchCount: Int, expectedPrize: Prize) {
        // when
        val prize = Prize.of(matchCount, false)

        // then
        assertThat(prize).isEqualTo(expectedPrize)
    }
}
