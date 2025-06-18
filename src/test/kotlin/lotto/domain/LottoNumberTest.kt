package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `throw exception when number is out of range`(outOfRange: Int) {
        assertThatThrownBy { LottoNumber(outOfRange) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

}