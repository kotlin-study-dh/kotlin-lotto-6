## LottoNumber

> Define: One Number on a lottery ball

- [ ] validate number is in the range 1 .. 45

## Lotto

> Define: A collection of six unique LottoNumber (single game)

- [ ] validate collection size is 6
- [ ] validate unique LottoNumber

## LottoTicket

> Define: A collection of Lotto purchased by user

## LottoMachine

- [ ] create LottoTicket

## PurchaseAmount

- [ ] validate amount is positive
- [ ] validate amount is multiple of 1,000
- [ ] calculate number of purchased Lotto
- [ ] calculate yield rate

## WinningLotto

> Define: A Lotto(winning numbers) and a LottoNumber(bonus number)

- [ ] validate bonus number is not included in the winning numbers

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
