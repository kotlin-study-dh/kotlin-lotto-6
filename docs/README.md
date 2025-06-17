## LottoNumber

> Define: One Number on a lottery ball

- [x] validate number is in the range 1 .. 45

## Lotto

> Define: A collection of six unique LottoNumber (single game)

- [x] validate collection size is 6
- [x] validate unique LottoNumber

## LottoMachine

- [ ] create Lotto list from LottoPurchaseAmount

## NumberGenerator

- [ ] generate random LottoNumber in the range 1 .. 45

## LottoPurchaseAmount

- [x] validate amount is greater than 1,000
- [x] validate amount is multiple of 1,000
- [x] calculate number of purchased Lotto
- [x] calculate rate of return

## Prize

- [x] define prize for each rank

## WinningLotto

> Define: A Lotto(winning numbers) and a LottoNumber(bonus number)

- [x] validate bonus number is not included in the winning numbers
- [x] compare winning numbers with Lotto

## InputView

- [ ] read purchase amount
    - [ ] validate purchase amount is integer
- [ ] read winning numbers
    - [ ] validate winning numbers are integers
    - [ ] validate winning numbers are separated by comma
- [ ] read bonus number
    - [ ] validate bonus number is integer

## OutputView

- [ ] print number of purchased Lotto and LottoTicket
- [ ] print winning results
- [ ] print yield rate
- [ ] print error message
