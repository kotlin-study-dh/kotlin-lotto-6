## LottoNumber

> Define: One Number on a lottery ball

- [x] validate number is in the range 1 .. 45

## Lotto

> Define: A collection of six unique LottoNumber (single game)

- [x] validate collection size is exactly 6
- [x] validate all LottoNumbers are unique
- [x] check Lotto contains a LottoNumber
- [x] compare one Lotto with another

## LottoMachine

- [x] create Lotto list from LottoPurchaseAmount
- [x] crate WinningLotto from winning numbers and bonus number
- [x] evaluate winning results by comparing Lotto with WinningLotto
- [x] calculate rate of return

## NumberGenerator

- [x] generate random LottoNumber in the range 1 .. 45

## LottoPurchaseAmount

- [x] validate amount is equal to or greater than 1,000
- [x] validate amount is multiple of 1,000
- [x] calculate number of purchased Lotto
- [x] calculate rate of return

## Prize

- [x] define prize for each winning rank

## WinningLotto

> Define: A Lotto(winning numbers) and a LottoNumber(bonus number)

- [x] validate bonus number is not included in the winning numbers
- [x] compare winning numbers with Lotto

## InputView

- [x] read purchase amount
    - [x] validate purchase amount is integer
- [x] read winning numbers
    - [x] split winning numbers by comma
    - [x] validate winning numbers are integers
- [x] read bonus number
    - [x] validate bonus number is integer

## OutputView

- [x] print number of purchased Lotto and Lotto list
- [x] print winning statistics
- [x] print rate of return
- [x] print error message
