package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {
    @ParameterizedTest(name = "invalid number = {arguments}")
    @ValueSource(ints = [0, 46])
    fun `fails to create LottoNumber with number less than 1 or greater than 45`(invalidNumber: Int) {
        // when & then
        assertThatThrownBy { LottoNumber.from(invalidNumber) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("Lotto number must be between 1 and 45.")
    }

    @ParameterizedTest(name = "valid number = {arguments}")
    @ValueSource(ints = [1, 45])
    fun `succeeds in creating LottoNumber with number between 1 and 45`(validNumber: Int) {
        // when
        val lottoNumber = LottoNumber.from(validNumber)

        // then
        assertThat(lottoNumber.number).isEqualTo(validNumber)
    }
}
