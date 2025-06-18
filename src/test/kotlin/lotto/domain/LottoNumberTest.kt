package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `throw exception when number is out of range`(outOfRange: Int) {
        assertThatThrownBy { LottoNumber(outOfRange) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `equals when the number is the same`() {
        val number1 = LottoNumber(1)
        val number2 = LottoNumber(1)

        assertThat(number1).isEqualTo(number2)
    }

}