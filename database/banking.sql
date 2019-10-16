-- Create the schema that we'll use to populate data and watch the effect in the binlog
CREATE SCHEMA banking;
SET search_path TO banking;

-- enable PostGis 
CREATE EXTENSION postgis;

-- Create and populate our products using a single insert with many rows
CREATE TABLE accounts (
  id SERIAL NOT NULL PRIMARY KEY,
  branch INTEGER NOT NULL,
  account INTEGER NOT NULL,
  name VARCHAR(255) NOT NULL,
  balance NUMERIC(15,2)
);
-- ALTER SEQUENCE accounts_id_seq RESTART WITH 101;
ALTER TABLE accounts REPLICA IDENTITY FULL;

INSERT INTO accounts
VALUES (default,1001,100,'Evandro Pires da Silva',1500.00),
       (default,1001,200,'Agenor Eustáquio',5250.00),
       (default,1002,100,'Maria Eleonor',12045.77);

-- Account Movements
CREATE TABLE movements (
  id SERIAL NOT NULL PRIMARY KEY,
  account_id INTEGER  NOT NULL,
  competence TIMESTAMP NOT NULL,
  value NUMERIC(15,2),
  FOREIGN KEY (account_id) REFERENCES accounts(id)
);
-- ALTER SEQUENCE accounts_id_seq RESTART WITH 101;
ALTER TABLE movements REPLICA IDENTITY FULL;