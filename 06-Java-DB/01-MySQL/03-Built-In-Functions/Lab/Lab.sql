-- SUBSTRING
SELECT SUBSTRING('Test String', 6);
SELECT SUBSTRING('TestString', 5);
SELECT SUBSTRING('Body', 4);

SELECT SUBSTR('Test some text', 1, 4);
SELECT SUBSTR('Test some text', 6, 4);
SELECT SUBSTR('Test some text', 16, 4);

SELECT SUBSTRING('Test some text' FROM 11 FOR 7);

-- REPLACE
SELECT REPLACE('Test some text', 'Te', 'Da');
SELECT REPLACE('Test some text', 'te', 'Da');
SELECT REPLACE('Test some text', 'fix', 'Da');
SELECT REPLACE('Test some text', 't', 'Da');

-- LTRIM AND RTRIM
SELECT LTRIM('   test');
SELECT ('        test');
SELECT RTRIM('test      ');

-- CHAR_LENGTH (count number of characters)
SELECT CHAR_LENGTH('Test');

-- LENGTH (get number of used bytes)
SELECT LENGTH('诶弟');

-- LEFT AND RIGHT
SELECT LEFT('Test some text', 4);
SELECT RIGHT('Test some text', 4);

-- LOWER AND UPPER
SELECT LOWER('TEST');
SELECT UPPER('test');

-- REVERSE
SELECT REVERSE('Test some text');

-- REPEAT
SELECT REPEAT('Test', 4);

-- LOCATE
SELECT LOCATE('so', 'Test some text');
SELECT LOCATE('t', 'Test some text');
SELECT LOCATE('t', 'Test some text', 3);
SELECT LOCATE('t', 'Test some text', 4);
SELECT LOCATE('t', 'Test some text', 10);

-- INSERT
SELECT INSERT('Test some text', 1, 4, 'New');

-- PI
SELECT PI();

-- ABS
SELECT ABS(-412);

-- SQRT
SELECT SQRT(16);

-- POW
SELECT POW(5, 2);

-- CONV
SELECT CONV(38, 10, 2);
SELECT CONV(223, 10, 16);

-- ROUND
SELECT ROUND(512.59098, 2);
SELECT ROUND(512.59598, 2);

-- FLOOR AND CEILING
SELECT FLOOR(5.50);
SELECT CEILING(5.50);

-- SIGN
SELECT SIGN(45), SIGN(0), SIGN(-23);

-- RAND
-- [13,27] 
-- [0,1) * 14
-- [0,14] + 13
-- [13,27]

SELECT FLOOR(RAND() * 14) + 13;

-- EXTRACT
SELECT EXTRACT(YEAR FROM '2024-09-12');
SELECT EXTRACT(YEAR FROM '12-09-2024');

SELECT EXTRACT(DAY FROM '2024-07-30');
SELECT EXTRACT(YEAR_MONTH FROM '2024-07-30');
SELECT EXTRACT(DAY_MINUTE FROM '2024-07-30 01:21:54');

-- TIMESTAMPDIFF
SELECT TIMESTAMPDIFF(month, '2003-12-24', '2010-05-01');
SELECT TIMESTAMPDIFF(year, '2003-12-24', '2010-05-01');
SELECT TIMESTAMPDIFF(day, '2003-12-24', '2010-05-01');

-- DATE_FORMAT
SELECT DATE_FORMAT('2017/05/31', '%d-%m-%y') AS `Date`;
SELECT DATE_FORMAT('2017/05/31', '%D-%M-%Y') AS `Date`;
SELECT DATE_FORMAT('2017/05/31', '%d-%m-%Y') AS `Date`;

-- NOW
SELECT NOW();

CREATE TABLE test (
	id INT NOT NULL UNIQUE PRIMARY KEY AUTO_INCREMENT,
    `time` TIMESTAMP
);

INSERT INTO test (`time`)
VALUES(NOW());

INSERT INTO test (`time`)
VALUES('2023-04-14');

INSERT INTO test (`time`)
VALUES('2001-02-19 13:32:59');

INSERT INTO test (`time`)
VALUES('1969-01-19 10:12:07');


SELECT * FROM test;
DROP TABLE test;
