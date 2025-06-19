## Requirement
- [x] range of lotto number : 1~45
- [x] one lotto has the unique 6 numbers
- winning numbers pick 6 numbers and 1 bonus number which are unique
- winning has 1st ~ 5th
    - 1st: 6 number match / 2,000,000,000won
    - 2nd: 5 number + bonus number match / 30,000,000won
    - 3rd: 5 number match / 1,500,000won
    - 4th: 4 number match / 50,000won
    - 5th: 3 number match/ 5,000won

- issue lottos corresponding the purchase amount. 
- one lotto is 1000won
- user enter wrong input
  - throw IllegalArgumentException
  - retry user input

## Input
- [x] purchase cose
  - unit : 1000 won
  - exception for not divided 1000won
- [x] numbers
  - range 1 ~ 45
  - winning numbers
    - seperate number by comma
    - ex) 1,2,3,4,5,6
  - bonus number
    - only one number


Output
- show number of lotto
- show lotto number order by ascending 
- show winning results
- profit rate is round to the second decimal place
- print the error which starts with '[ERROR]'

### Result
```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]<br>
[3, 5, 11, 16, 32, 38]<br>
[7, 11, 16, 35, 36, 44]<br>
[1, 8, 11, 31, 41, 42]<br>
[13, 14, 16, 38, 42, 45]<br>
[7, 11, 30, 40, 42, 43]<br>
[2, 13, 22, 32, 38, 45]<br>
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```
