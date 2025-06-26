# Feature Requirements

## Rule

- [x] Draw 6 non-overlapping numbers when issuing 1 lotto ticket.

### Lotto     
  - [x] The lotto has six numbers.

### Lotto number
- Lotto numbers can range from 1 to 45.
  - [x] Throw an exception if the lotto number is out of range.

### Drawing winning numbers
  - [x] The winning numbers are drawn from 6 non-overlapping numbers and 1 bonus number.
  
### Winning Criteria
  - There are prizes for first through fifth place. The criteria and prize amounts are as follows
    - [x] 1st prize: 6 number matches / 2,000,000,000 KRW
    - [x] 2nd place: Match 5 numbers + bonus number / 30,000,000 KRW
    - [x] 3rd place: Match 5 numbers / 1,500,000 KRW
    - [x] 4th place: Match 4 numbers / 50,000 KRW
    - [x] 5th place: Match 3 numbers / 5,000 KRW

### Lotto progression
- [x] After you enter the lotto purchase amount, you need to issue lotto tickets for the amount of the purchase.
- [x] One lotto ticket costs 1,000 won.
- [x] Enter the winning number and bonus number.
- [x] Compares the user's purchased lotto numbers with the winning numbers, prints the winning details and percentage, and ends the lotto game.
- [x] If the user enters an invalid value, raise an IllegalArgumentException, print an error message starting with "[ERROR]", and accept the input again from that point.
- [x] Handle unambiguous types such as IllegalArgumentException, IllegalStateException, etc. rather than Exception.

## Input Requirements

- You can enter the amount of your lotto purchase.
  - [x] The purchase amount is entered in 1,000 won increments.
  - [x] Exception if the purchase amount is not divisible by 1,000 won.
- [x] Enter the winning number.
  - [x] The numbers are separated by commas (,).
- [x] Enter the bonus number.


## Output Requirements

- [x] Print the number of lotto tickets issued and the numbers.
- [x] Lotto numbers are displayed in ascending order.
- [x] Print the winning details.
- [x] Returns are rounded to the second decimal place. (ex. 100.0%, 51.5%, 1,000,000.0%)
- [x] An error message should be printed when an exception occurs. However, the error text must start with "[ERROR]".
