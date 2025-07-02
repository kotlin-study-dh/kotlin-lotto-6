package lotto.domain

import lotto.domain.number.FixedNumberGenerator
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoIssuerTest {

    @Test
    fun `issue the lotto numbers`() {
        // given
        val numberGenerator = FixedNumberGenerator()
        val issuer = LottoIssuer(numberGenerator)

        // when
        val numbers = issuer.issue()

        // then
        Assertions.assertThat(numbers.winningNumbers)
            .hasSize(6)
    }
}