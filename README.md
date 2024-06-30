Database SQL lite

Create Table in sql lite-

create table BankingWaiyatSystem(Id Int PRIMARY KEY NOT NULL, Name VARCHAR(30) NOT NULL, TypeOfUser VARCHAR(30)NOT NULL,Email VARCHAR(30),Address VARCHAR(50),Phone VARCHAR(15),Balance DECIMAL (15,2) );


Insert just the Admin to that table -
INSERT INTO BankingWaiyatSystem(Id,Name,TypeOfUser,Email,Address,Phone,Balance)
VALUES(0,'Waiyat Hamdani','ADMIN','waiyat@imsol.com','1 lovelyrunner st' ,'203-111-2222', 999999); 

select-
select * from BankingWaiyatSystem;

just to save the file -
.save BankingWaiyatSystem.db
