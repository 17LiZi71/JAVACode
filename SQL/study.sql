SHOW DATABASES;
--@block
SELECT *
FROM users;
--@block
SELECT *
FROM cars;
--@blockcars
SELECT *
FROM Adminis;
--@block
alter TABLE users
add phone Varchar(50) not null;
--@block
alter TABLE users add rentInformation1 Varchar(50);
--@block
ALTER TABLE users drop column ordNumber;
--@block
SHOW create TABLE users;