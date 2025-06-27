package lotto.generator

import org.assertj.core.api.SoftAssertions
import org.junit.jupiter.api.Test

class RandomNumbersGeneratorTest {
    @Test
    fun `generate 6 unique numbers within the range`() {
        // given
        val generator = RandomNumbersGenerator()

        // when
        val numbers = generator.generate()

        // then
        SoftAssertions.assertSoftly { softly ->
            softly.assertThat(numbers).hasSize(6)
            softly.assertThat(numbers).allMatch { it in 1..45 }
            softly.assertThat(numbers.distinct()).hasSize(6) // Check for uniqueness
        }
    }
}
