This project 


My Plan:
user -------->               account     ->withdraw
                                         ->deposit
                                         ->transfer  


user:userid, firstname ,lastname ,phone ,address ,email

account: Account id ,username ,password ,balance ,accounttype ,userid

withdrawal:accounted ,date ,ammountwithdrawal ,withdrawid
deposit:depositid ,date ,amount_deposit ,accountid
Transfer :transferid ,from_accountid ,to_accountid ,amount ,date










use prostgress (for database , Java for main language)



Cheat Cheat
To compile the maven
mvn compile


Database SQL 

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

select --
select * from wbank;

just to save the file -
.save BankingWaiyatSystem.db
