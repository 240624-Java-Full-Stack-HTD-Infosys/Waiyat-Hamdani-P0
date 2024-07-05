-- just in case if something wrong on table
--drop table userwbank;
--drop table accountwbank;
--drop table withdrawalwbank;
--drop table transferwbank;

CREATE TABLE userwbank
(
userid SERIAL PRIMARY KEY NOT NULL,
firstname VARCHAR(45) NOT NULL,
lastname VARCHAR(45) NOT NULL,
phone VARCHAR(19),
address VARCHAR(80),
email VARCHAR(50)
);

CREATE TABLE accountwbank
(
    username VARCHAR(100),
    password VARCHAR(100),
    accountid INT PRIMARY KEY,
    balance DECIMAL(14, 2),
    accounttype VARCHAR(50),
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

CREATE TABLE depositwbank (
    depositid INT PRIMARY KEY,
    accountid INT,
    date DATE,
    amountdeposit DECIMAL(10, 2),
    FOREIGN KEY (accountid) REFERENCES accountwbank(accountid)
);


CREATE TABLE transferwbank
(
    transferid SERIAL PRIMARY KEY NOT NULL,
    from_accountid INT,
    to_accountid INT,
    amount DECIMAL(15, 2) NOT NULL,
    date DATE NOT NULL,
    FOREIGN KEY (from_accountid) REFERENCES accountwbank(accountid),
    FOREIGN KEY (to_accountid) REFERENCES accountwbank(accountid)
);

INSERT INTO wbank (Firstname,Lastname,TypeOfUser,Email,Address,Phone,Balance,Password)
values ('Waiyat', 'Hamdani','ADMIN','waiyat@imsol.com','1 lovelyrunner st' ,'203-111-2222', 999999,'admin'); 

select * from userwbank;




COMMIT;