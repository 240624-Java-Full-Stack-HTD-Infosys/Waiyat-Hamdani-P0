This project 


My Plan:
user -------->             account        
	          |	     |                 |
	          v          v                 V
             withdraw       deposit          transfer



user:
firstname 
lastname
phone 
address
userid
email


account: 
username
password
accounted
balance
accounttype
userid


withdrawal:
accounted
date
ammountwithdrawal
withdrawid


deposit:
depositid 
date
amount deposit
accountid


Transfer
transferid
from_accountid
to_accountid
amount
date













































Cheat Cheat


To compile the maven
mvn compile


Database SQL lite

CREATE TABLE userwbank
(
userid SERIAL PRIMARY KEY NOT NULL,
firstname VARCHAR(45) NOT NULL,
lastname VARCHAR(45) NOT NULL,
phone VARCHAR(19),
address VARCHAR(80),
email VARCHAR(50),
accountid INT,
FOREIGN KEY (accountid) REFERENCES accountwbank(accountid)
);

CREATE TABLE accountwbank
(
username VARCHAR(100),
password VARCHAR(100),
account_id INT PRIMARY KEY,
balance DECIMAL(14, 2),
account_type VARCHAR(50),
userid INT,
FOREIGN KEY (userid) REFERENCES userwbank(userid)
);

CREATE TABLE withdrawalwbank (
withdrawid INT PRIMARY KEY,
accountid INT,
date DATE,
amountwithdrawal DECIMAL(10, 2),
FOREIGN KEY (accountid) REFERENCES accountwbank(accountid)
);

select --
select * from wbank;

just to save the file -
.save BankingWaiyatSystem.db
