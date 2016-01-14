/* 
LegoBatmanFan SQL Assessment

Run the following commands from the command line FIRST!!!
1. Log in...
	mysql -u root -p <ENTER> - then enter your password
2. Check to see if the database exists. If it exists, remove/delete it
	SHOW DATABASES;
	DROP DATABASE databaseName
3. Make sure the database has been deleted:
	SHOW DATBASES;
4. Create the database and select it..
	CREATE DATABASE assessment;
	USE assessment;
5.  run the script  
	source \SQLite3\20151220_lhorsley_sql_assessment.sql
*/

/*Drop the tables if they exist*/
SELECT 'Drop the salesperson, customer, and orders tables if they exist' AS ' ';
DROP TABLE IF EXISTS salesperson;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS orders;


/* Create and populate the salesperson table */
SELECT 'Creating SALESPERSON table' AS ' ';
CREATE TABLE salesperson (
	ID int NOT NULL,
	Name varchar(255) NOT NULL,
	Age int NOT NULL,
	Salary float NOT NULL
);

SELECT 'SALESPERSON table created. Now inserting data into SALESPERSON table' AS ' ';
INSERT INTO salesperson (ID, Name, Age, Salary) VALUES (1, "Abe", 61, 140000);
INSERT INTO salesperson (ID, Name, Age, Salary) VALUES (2, "Bob", 34, 44000);
INSERT INTO salesperson (ID, Name, Age, Salary) VALUES (5, "Chris", 61, 40000);
INSERT INTO salesperson (ID, Name, Age, Salary) VALUES (7, "Dan", 41, 52000);
INSERT INTO salesperson (ID, Name, Age, Salary) VALUES (8, "Ken", 57, 115000);
INSERT INTO salesperson (ID, Name, Age, Salary) VALUES (11, "Joe", 38, 38000);

/* Create and populate the customer table */
SELECT 'Creating CUSTOMER table' AS ' ';
CREATE TABLE customer (
	ID int NOT NULL,
	Name varchar(255) NOT NULL,
	City varchar(255) NOT NULL,
	Industry_Type char(1) NOT NULL
);

SELECT 'CUSTOMER table created. Now inserting data into CUSTOMER table ' AS ' ';
INSERT INTO customer (ID, Name, City, Industry_Type) VALUES (4, "Samsonic", "pleasant", "J");
INSERT INTO customer (ID, Name, City, Industry_Type) VALUES (6, "Panasung", "oaktown", "J");
INSERT INTO customer (ID, Name, City, Industry_Type) VALUES (7, "Samony", "jackson", "B");
INSERT INTO customer (ID, Name, City, Industry_Type) VALUES (9, "Orange", "Jackson", "B");

/* Create and populate the orders table */
SELECT 'Creating ORDERS table' AS ' ';
CREATE TABLE orders (
	order_number int NOT NULL,
	order_date DATE NOT NULL,
	cust_id int NOT NULL,
	salesperson_id int NOT NULL,
	Amount float NOT NULL
);

SELECT 'ORDERS table created. Now inserting data into ORDERS table ' AS ' ';
INSERT INTO orders (order_number, order_date, cust_id, salesperson_id, Amount) VALUES (10, "1996-08-02", 4, 2, 540);
INSERT INTO orders (order_number, order_date, cust_id, salesperson_id, Amount) VALUES (20, "1999-01-30", 4, 8, 1800);
INSERT INTO orders (order_number, order_date, cust_id, salesperson_id, Amount) VALUES (30, "1995-07-14", 9, 1, 460);
INSERT INTO orders (order_number, order_date, cust_id, salesperson_id, Amount) VALUES (40, "1998-01-29", 7, 2, 2400);
INSERT INTO orders (order_number, order_date, cust_id, salesperson_id, Amount) VALUES (50, "1998-02-03", 6, 7, 600);
INSERT INTO orders (order_number, order_date, cust_id, salesperson_id, Amount) VALUES (60, "1998-03-02", 6, 7, 720);
INSERT INTO orders (order_number, order_date, cust_id, salesperson_id, Amount) VALUES (70, "1998-05-06", 9, 7, 150);

/* Return all of the data from the Salesperson table */
SELECT 'Return all of the data from the Salesperson table ' AS ' ';
SELECT * FROM salesperson;

/*the names of all salespeople that have an order with Samsonic*/
SELECT 'Return all of the names of all salespeople that have an order with Samsonic' AS ' ';
SELECT DISTINCT salesperson.Name FROM salesperson, orders WHERE salesperson.ID = orders.salesperson_id AND orders.cust_id = 4;

/*the names of salespeople that have 2 or more orders*/
SELECT 'Return all of the names of salespeople that have 2 or more orders' AS ' ';
SELECT salesperson.Name FROM salesperson, orders WHERE salesperson.ID = orders.salesperson_id GROUP BY salesperson_id HAVING COUNT(salesperson_id) >= 2;