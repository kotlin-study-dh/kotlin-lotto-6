package lotto.domain

import lotto.constant.LottoConstants

data class LottoNumber(val number: Int) {

    init {
        require(number in LottoConstants.MIN_NUMBER..LottoConstants.MAX_NUMBER) {
            "Lotto number must be between ${LottoConstants.MIN_NUMBER} and ${LottoConstants.MAX_NUMBER}."
        }
    }
}
