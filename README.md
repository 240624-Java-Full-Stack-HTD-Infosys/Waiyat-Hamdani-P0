Database SQL lite

Create Table in sql lite-

create table BankingRevatureWaiyatSystem(Id Int PRIMARY KEY NOT NULL, TypeOfUser VARCHAR(30)NOT NULL,Email VARCHAR(30),Address VARCHAR(50),Phone VARCHAR(15),Balance DECIMAL (15,2) );


Insert just the Admin to that table -
INSERT INTO BankingRevatureWaiyatSystem(Id,TypeOfUser,Email,Address,Phone,Balance)
VALUES(0,'ADMIN','waiyat@imsol.com','1 lovelyrunner st' ,'203-111-2222', 999999); 

select-
select * from BankingRevatureWaiyatSystem;

just to save the file -
.save BankingRevatureWaiyatSystem.db
