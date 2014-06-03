CREATE DATABASE step;

GRANT ALL ON step.* TO springappuser@'%' IDENTIFIED BY 'pspringappuser';
GRANT ALL ON step.* TO springappuser@localhost IDENTIFIED BY 'pspringappuser';

USE step;

CREATE TABLE accounts (
  id varchar(9) PRIMARY KEY,
  comision decimal(5,2)
);
CREATE INDEX accounts_comision ON accounts(comision);