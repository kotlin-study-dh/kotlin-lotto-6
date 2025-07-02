package lotto.domain

import lotto.domain.number.Number
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = [1, 45])
    fun `make sure the number is within the valid range`(number: Int) {
        assertDoesNotThrow { Number(number) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `throw an exception when the number is outside the range`(number: Int) {
        assertThrows<IllegalArgumentException> { Number(number) }
    }
}