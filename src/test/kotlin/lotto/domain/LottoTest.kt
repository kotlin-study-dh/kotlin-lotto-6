package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test


class LottoTest {
    @Test
    fun `fails to create Lotto with less than 6 LottoNumber`() {
        // given
        val invalidSizeLottoNumbers = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5)
        )

        // when & then
        assertThatThrownBy { Lotto(invalidSizeLottoNumbers) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("A Lotto must contain exactly 6 numbers.")
    }

    @Test
    fun `fails to create Lotto with more than 6 LottoNumber`() {
        // given
        val invalidSizeLottoNumbers = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6),
            LottoNumber.from(7)
        )

        // when & then
        assertThatThrownBy { Lotto(invalidSizeLottoNumbers) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("A Lotto must contain exactly 6 numbers.")
    }

    @Test
    fun `fails to create Lotto with duplicated LottoNumber`() {
        // given
        val duplicateLottoNumbers = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(1) // duplicated number
        )

        // when & then
        assertThatThrownBy { Lotto(duplicateLottoNumbers) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Lotto numbers must be unique.")
    }

    @Test
    fun `succeeds in creating Lotto with 6 unique LottoNumber`() {
        // given
        val validLottoNumbers = listOf(
            LottoNumber.from(1),
            LottoNumber.from(2),
            LottoNumber.from(3),
            LottoNumber.from(4),
            LottoNumber.from(5),
            LottoNumber.from(6)
        )

        // when
        val lotto = Lotto(validLottoNumbers)

        // then
        assertThat(lotto.getSortedNumbers()).containsExactlyInAnyOrderElementsOf(validLottoNumbers)
    }
}
