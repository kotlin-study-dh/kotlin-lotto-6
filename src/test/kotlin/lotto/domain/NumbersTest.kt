package lotto.domain

import lotto.domain.number.BonusNumber
import lotto.domain.number.Numbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NumbersTest {

    @Test
    fun `make sure the numbers are not duplicated`() {
        Assertions.assertThatCode { Numbers.fromInts(1, 2, 3, 4, 5, 6) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `throw exception if numbers are duplicate`() {
        Assertions.assertThatThrownBy { Numbers.fromInts(1, 2, 3, 4, 5, 5) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `the selection must include 6 winning numbers`() {
        Assertions.assertThatCode { Numbers.fromInts(1, 2, 3, 4, 5, 6) }
            .doesNotThrowAnyException()
    }

    @Test
    fun `throw exception if selection numbers are not included 6`() {
        Assertions.assertThatThrownBy { Numbers.fromInts(1, 2, 3, 4, 5, 6, 7) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun `returns the number of overlapping elements in the array`() {
        // given
        val numbers = Numbers.fromInts(1, 2, 3, 4, 5, 6)
        val otherNumbers = Numbers.fromInts(1, 2, 3, 4, 5, 7)

        // when
        val match = numbers.match(otherNumbers)

        // then
        Assertions.assertThat(match).isEqualTo(5)
    }

    @Test
    fun `check the match with bonus number`() {
        // given
        val bonusNumber = BonusNumber(1)
        val numbers = Numbers.fromInts(1, 2, 3, 4, 5, 6)

        // when
        val match = numbers.match(bonusNumber)

        // then
        Assertions.assertThat(match).isTrue
    }

    @Test
    fun `check the does not match with bonus number`() {
        // given
        val bonusNumber = BonusNumber(7)
        val numbers = Numbers.fromInts(1, 2, 3, 4, 5, 6)

        // when
        val match = numbers.match(bonusNumber)

        // then
        Assertions.assertThat(match).isFalse
    }

    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Numbers.fromInts(1, 2, 3, 4, 5, 6, 7)
        }
    }

    // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Numbers.fromInts(1, 2, 3, 4, 5, 5)
        }
    }

}