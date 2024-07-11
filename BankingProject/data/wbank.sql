--just in case if something wrong on table
drop table depositwbank;
drop table withdrawalwbank;
drop table transferwbank;
drop table accountwbank;
drop table userwbank;

CREATE TABLE userwbank
(
userid SERIAL PRIMARY KEY NOT NULL,
firstname VARCHAR(45) NOT NULL,
lastname VARCHAR(45) NOT NULL,
phone VARCHAR(19),
address VARCHAR(80),
email VARCHAR(50) UNIQUE,
username VARCHAR(100) unique NOT NULL,
password VARCHAR(100) NOT NULL
);

CREATE TABLE accountwbank
(
	accountid SERIAL PRIMARY key,
    balance DECIMAL(14, 2),
    accounttype VARCHAR(50),
    userid INT,
    FOREIGN KEY (userid) REFERENCES userwbank(userid)
);

CREATE TABLE withdrawalwbank (
    withdrawid SERIAL PRIMARY KEY,
    accountid INT,
    date DATE,
    amountwithdrawal DECIMAL(10, 2),
    FOREIGN KEY (accountid) REFERENCES accountwbank(accountid)
);

CREATE TABLE depositwbank (
    depositid SERIAL PRIMARY KEY,
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


select * from userwbank;
select * from accountwbank;
select * from depositwbank;
select * from withdrawalwbank;
select * from transferwbank;



select * from userwbank u 
join accountwbank a on u.userid  = a.userid 
order by u.userid asc ;

select * from userwbank u join accountwbank a 

COMMIT;