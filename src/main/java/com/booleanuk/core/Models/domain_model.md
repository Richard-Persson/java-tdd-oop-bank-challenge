
| Classes  | Methods                         | Scenario                               | Outputs |
| -------- | ------------------------------- | -------------------------------------- | ------- |
|          |                                 |                                        |         |
| Account  | boolean deposit(double amount)  | amount is positive                     | true    |
|          |                                 | amount is negative                     | false   |
| Account  | boolean withdraw(double amount) | amount is less than current balance    | true    |
|          |                                 | amount is greater than current balance | false   |
| Customer | createCurrentAccount()          | customer already has current account   | false   |
|          |                                 | customer dosen't have current account  | true    |
| Customer | createSavingsAccount()          | customer already has savings account   | false   |
|          |                                 | customer dosen't have savings account  | true    |
|          |                                 |                                        |         |
