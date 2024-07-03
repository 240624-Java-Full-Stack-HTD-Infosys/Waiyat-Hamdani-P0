create table wbank(Id SERIAL PRIMARY KEY NOT NULL,
Firstname VARCHAR(30) NOT NULL, 
Lastname VARCHAR(30) NOT NULL,
TypeOfUser VARCHAR(30)NOT NULL,
Email VARCHAR(30),
Address VARCHAR(50),
Phone VARCHAR(15),
Balance DECIMAL (15,2),
Password VARCHAR(30) NOT NULL );


INSERT INTO wbank (Firstname,Lastname,TypeOfUser,Email,Address,Phone,Balance,Password)
values ('Waiyat', 'Hamdani','ADMIN','waiyat@imsol.com','1 lovelyrunner st' ,'203-111-2222', 999999,'admin'); 

select * from wbank;

COMMIT;