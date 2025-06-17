# Mission Lottery
## Requirement
### Functional Requirement
#### Lottery Numbers
- Range: 1–45
- You must choose six unique numbers.
- Additionally, you need to select one bonus number.

#### Reward
- First: 2_000_000_000 won
- Second: 30_000_000 won
- Third: 1_500_000 won
- Forth: 50_000 won
- Fifth: 5_000 won

### Programming Requirement
- You must throw an IllegalArgumentException when the user provides invalid input. 
    - also print an error message to the console, it should start wtih "[ERROR]"
- You must specify the exception type clearly — for example, do not use Exception; use IllegalArgumentException instead.

### Implementation Checklist
Break down the implementation into three parts: input logic, output logic, and domain logic.

- Input 
  - [ ] purchase amount
  - [ ] guess winning number
    - [ ] separated by commas.
  - [ ] bonus number

- Output
  - [ ] purchased lottery
    - [ ] Display the lotteries in order.
  - [ ] winning detail
  - [ ] total revenue
    - [ ] The revenue rate should be rounded to one decimal place. 

- Domain (Write the domain logic checklist by component or class)
  - [ ] Number
    - [ ] Make sure the number is within the valid range.
    - [ ] Two types of Number
      - [ ] Winning Number
      - [ ] Bonus Number
  - [ ] Lotto Numbers
    - [ ] Make sure the numbers are not duplicated.
    - [ ] The selection must include 6 winning numbers. 
    - [ ] One additional bonus number can also be added. 
  - [ ] Lotto Issuer
    - [ ] Generate several Lotto Numbers
  - [ ] Lotto Inspector
    - [ ] Determine the Lotto grade.
  - [ ] Lotto Game
    - [ ] Throw an exception when the purchase amount is not divisible by 1,000
    - [ ] calculate the total revenue percentage.