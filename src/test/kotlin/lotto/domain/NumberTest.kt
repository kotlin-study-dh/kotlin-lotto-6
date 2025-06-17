package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 45])
    fun `make sure the number is within the valid range`(number: Int) {
        Assertions.assertThatCode { Number(number) }
            .doesNotThrowAnyException()
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `throw an exception when the number is outside the range`(number: Int) {
        Assertions.assertThatThrownBy { Number(number) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}