SHOW DATABASES;
--@block
SELECT *
from user_tb;
--@block
SELECT *
FROM vehicle_tb;
--@block
use rentdbs;
--@block
SELECT * FROM business;
--@block
alter table vehicle_tb
add vehicle_number VARCHAR(50) not null;
--@block
alter table user_tb drop ;
--@block
select distinct brand
from vehicle_tb
where type = '轿车';
--@block
insert into user_tb(
        user_name,
        user_pwd,
        user_address,
        user_phone,
        permissions
    )
values('hhh', 'hhh1', '山东', '151','Vip');
--@block
UPDATE user_tb SET orders1 = 'default' WHERE user_name='hhh';
--@block
UPDATE vehicle_tb SET type = '客车' WHERE brand ='金龙';
--@block
update  business set turnover = 0;
--@block
INSERT INTO business (turnover) VALUES (0);
--@block
update user_tb set permissions='Vip' WHERE user_id =7;
--@block
delete from user_tb where user_id=8;