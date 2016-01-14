/*
FiZzBuZz - LegoBatman Fan
if a number if a multiple of 3, print "FIZZ"
if the number is a multiple of 5, print "BUZZ"
if the number is a multiple of 3 and 5 print FIZZBUZZ"
check for i % 15 first, then check for 3 or 5 because you
want multiples of 15 to print out "FIZZBUZZ" instead of
"Fizz" or "Buzz."
*/

/* Drop the "numbers' table if it exists  */
SELECT 'Checking to see if the numbers table exists...drop the table if it exists...' AS ' ';
DROP TABLE IF EXISTS numbers;

/* Create the numbers table */
SELECT 'Creating the numbers table...' AS ' ';
CREATE TABLE numbers(x INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY);


/* Insert some values in the table */
SELECT 'Insert first 50 records into the numbers table...' AS ' ';
INSERT INTO numbers VALUES (), (), (), (), (), (), (), (), (), ();
INSERT INTO numbers VALUES (), (), (), (), (), (), (), (), (), ();
INSERT INTO numbers VALUES (), (), (), (), (), (), (), (), (), ();
INSERT INTO numbers VALUES (), (), (), (), (), (), (), (), (), ();
INSERT INTO numbers VALUES (), (), (), (), (), (), (), (), (), ();

/*
 Copy the records from the numbers table into a temporary table. Next, copy the from the temporary 
 table into the numbers table. As the number is copied from tmptable_1, it's incremented by 50. The
 temporary table is dropped
*/
SELECT 'Insert next 50 records into the numbers table...' AS ' ';
CREATE TEMPORARY TABLE tmptable_1 SELECT * FROM numbers;
INSERT INTO numbers SELECT x+50 FROM tmptable_1;
DROP TEMPORARY TABLE IF EXISTS tmptable_1;

/* Now do the FiZzBuZz */
SELECT 'Now, FiZzBuZz...' AS ' ';
SELECT CASE
    WHEN MOD(x,15)=0 THEN 'FiZzBuZz'
    WHEN MOD(x,3)=0 THEN 'Fizz'
    WHEN MOD(x,5)=0 THEN 'Buzz'
    ELSE x
    END AS "FizzBuzz!"
FROM numbers ORDER BY x;


