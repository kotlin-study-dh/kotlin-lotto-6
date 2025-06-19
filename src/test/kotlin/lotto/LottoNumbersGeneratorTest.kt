package lotto

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test

class LottoNumbersGeneratorTest {

    @Test
    fun `verify LottoNumbersGenerator generate unique value`() {
        val randomNumbers = LottoNumbersGenerator.generate()
        assertThat(randomNumbers.size).isEqualTo(randomNumbers.toSet().size)
    }

    @Test
    fun `verify LottoNumbersGenerator generate sorted value`() {
        val randomNumbers = LottoNumbersGenerator.generate()
        assertThat(randomNumbers).isEqualTo(randomNumbers.sorted())
    }
}
