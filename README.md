All Syntax
===================login===============
Login account   <http://localhost:8080/login>
{
"username":" ",
"password":" "
}

=====================register ====================
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


we do have root /  <http://localhost:8080/>
to reset the server funny everytime register account it store to database but it dont do login
.the postman not ready to take it

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
