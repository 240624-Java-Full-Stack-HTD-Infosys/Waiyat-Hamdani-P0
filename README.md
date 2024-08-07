Tech: Javalin and postgres

All Syntax

Login account   <http://localhost:8080/login>
{
"username":" ",
"password":" "
}

Register User/ New account <
{
"user": {
"firstname": " ",
"lastname": " ",
"phone": " ",
"address": " ",
"email": " ",
"username": " ",
"password": " "
},
"account":
{
"balance": 20,
"accountType": " "
}
}



===========Account stuff  (in here has to be login first) ===============
authentication after login <http://localhost:8080/auth>

Deposit <http://localhost:8080/auth/deposit>
{
"amountDeposit": 3000
}

Withdraw <http://localhost:8080/auth/withdraw>
{
"amountWithdrawal": 3000
}

transfer <http://localhost:8080/auth/transfer>
{
"toAccountId":2,
"amount": 3000
}

Create Extra account <http://localhost:8080/auth/createExtraAccount>
{
"balance": 2000.0,
"accountType": "saving"
}

delete account <http://localhost:8080/auth/deleteAccount>
{
"accountId": 3
}




====================================in account ================================

ERD is on ERD Image 
to see Powerpoint should be under Waiyat project-0
