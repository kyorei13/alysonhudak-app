
/* delete tables if they exist already - ensuring a clean db*/
DROP TABLE IF EXISTS person_quotes CASCADE;
DROP TABLE IF EXISTS quotes CASCADE;
DROP TABLE IF EXISTS person CASCADE;

/* creates a table to store a list of stock quotes */
CREATE TABLE quotes(
   id INT NOT NULL AUTO_INCREMENT,
   symbol VARCHAR(4) NOT NULL,
   time DATETIME NOT NULL,
   price DECIMAL NOT NULL,
   PRIMARY KEY ( id )
);

/** creates a table to store a list of people */
CREATE TABLE person
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(256) NOT NULL,
  last_name VARCHAR(256) NOT NULL,
  birth_date DATETIME NOT NULL
);

/** A list of people and their quotes */
CREATE TABLE person_quotes
(
  ID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  person_id INT NOT NULL,
  quote_id INT NOT NULL,
  FOREIGN KEY (person_id) REFERENCES person (ID),
  FOREIGN KEY (quote_id) REFERENCES quotes (ID)
);

/** now add some sample data */

INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2004-08-19 00:00:01','85.00');
INSERT INTO quotes (symbol,time,price) VALUES ('GOOG','2015-02-03 00:00:01','527.35');
INSERT INTO quotes (symbol,time,price) VALUES ('APPL','2000-01-01 00:00:01','118.27');
INSERT INTO quotes (symbol,time,price) VALUES ('AMZN','2015-02-10 00:00:01','363.21');
INSERT INTO quotes (symbol,time,price) VALUES ('AMZN','2015-02-10 00:01:01','363.21');
INSERT INTO quotes (symbol,time,price) VALUES ('AMZN','2015-02-10 00:02:01','250.21');
INSERT INTO quotes (symbol,time,price) VALUES ('AMZN','2015-02-10 00:03:01','251.21');
INSERT INTO quotes (symbol,time,price) VALUES ('AMZN','2015-02-10 00:04:01','253.21');

INSERT INTO person (first_name,last_name,birth_date) VALUES ('John', 'Doe', '1950/10/31');
INSERT INTO person (first_name,last_name,birth_date) VALUES ('Orion', 'Shazam', '2002/12/13');
INSERT INTO person (first_name,last_name,birth_date) VALUES ('Lucille', 'Ball', '1937/04/01');
INSERT INTO person (first_name,last_name,birth_date) VALUES ('Super', 'Man', '1975/2/15');
INSERT INTO person (first_name,last_name,birth_date) VALUES ('Wonder', 'Woman', '1984/03/19');

INSERT INTO person_quotes (ID, person_id, quote_id) VALUES (1, 1, 2);
INSERT INTO person_quotes (ID, person_id, quote_id) VALUES (2, 1, 1);
INSERT INTO person_quotes (ID, person_id, quote_id) VALUES (3, 2, 1);
INSERT INTO person_quotes (ID, person_id, quote_id) VALUES (4, 3, 1);
INSERT INTO person_quotes (ID, person_id, quote_id) VALUES (5, 3, 3);
INSERT INTO person_quotes (ID, person_id, quote_id) VALUES (6, 5, 4);
INSERT INTO person_quotes (ID, person_id, quote_id) VALUES (7, 4, 7);
