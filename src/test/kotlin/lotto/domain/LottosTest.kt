package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottosTest {
    @Test
    fun `generates lottos from lotto count`() {
        val lottoCount = 3
        val lottos = Lottos.from(lottoCount)

        assertThat(lottos.items.size).isEqualTo(3)
    }
}