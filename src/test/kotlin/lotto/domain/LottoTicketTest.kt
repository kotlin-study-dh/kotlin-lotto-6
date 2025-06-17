package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoTicketTest {
    @Test
    fun `fails to create LottoTicket with empty Lotto`() {
        // given
        val emptyLottos = emptyList<Lotto>()

        // when & then
        assertThatThrownBy { LottoTicket(emptyLottos) }
            .isExactlyInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("A LottoTicket must contain at least one Lotto.")
    }

    @Test
    fun `succeeds in creating LottoTicket with at least one Lotto`() {
        // given
        val lottos = listOf(
            Lotto(
                listOf(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(4),
                    LottoNumber.from(5),
                    LottoNumber.from(6)
                )
            ),
        )

        // when
        val lottoTicket = LottoTicket(lottos)

        // then
        assertThat(lottoTicket.getLottoQuantity()).isEqualTo(1)
    }
}
