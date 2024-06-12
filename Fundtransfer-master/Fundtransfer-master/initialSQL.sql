create database fundTransfer;
use fundTransfer;
CREATE TABLE beneficiary (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    account_number varchar(255) NOT NULL,
    account_Number2 varchar(255) NOT NULL,
    nick_name varchar(255) NULL,
    PRIMARY KEY (id)
);