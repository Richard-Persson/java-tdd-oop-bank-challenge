

| Classes       | Methods                                    | Scenario                                              | Outputs                             |
| ------------- | ------------------------------------------ | ----------------------------------------------------- | ----------------------------------- |
|               |                                            |                                                       |                                     |
| Account       | boolean deposit(double amount)             | amount is positive                                    | true                                |
|               |                                            | amount is negative                                    | false                               |
| Account       | boolean withdraw(double amount)            | amount is less than current balance                   | true                                |
|               |                                            | amount is greater than current balance                | false                               |
| Account       | createCurrentAccount()                     | customer already has current account                  | false                               |
|               |                                            | customer dosen't have current account                 | true                                |
| Account       | createSavingsAccount()                     | customer already has savings account                  | false                               |
|               |                                            | customer dosen't have savings account                 | true                                |
| Account       | BankStatement getBankStatement(Account ac) | account is created and there exists an bank statement | bankstatement with all transactions |
|               |                                            | account dosen't exist                                 | null                                |
|               |                                            | bank statement dosen't exist                          | null                                |
| BankStatement | List\<transactions\>getTransactoins()      | if there exists transactions                          | List of all transactions            |
|               |                                            | no transactions exists                                | null                                |
| Account       | boolean requestOverdarft(double amount)    | amount does not go past limit                         | true                                |
|               |                                            | amount exceeds limit                                  | false                               |
|               |                                            |                                                       |                                     |
|               |                                            |                                                       |                                     |
|               |                                            |                                                       |                                     |
|               |                                            |                                                       |                                     |

