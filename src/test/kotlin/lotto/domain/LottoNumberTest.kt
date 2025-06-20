package lotto.domain

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `throw exception when number is out of range`(outOfRange: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber(outOfRange)  }
    }

    @Test
    fun `equals when the number is the same`() {
        val number1 = LottoNumber(1)
        val number2 = LottoNumber(1)

        assert(number1 == number2)
    }

}