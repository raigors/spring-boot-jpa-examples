-- insert into `SystemUserEntity`(`username`, `password`, `phone`, `deleted`) values('admin1', '123445', '18888888812', 1);
-- insert into `SystemUserEntity`(`username`, `password`, `phone`, `deleted`) values('admin2', '1234566', '188888881234', 1);

INSERT INTO `SystemUserEntity` (`username`, `password`, `phone`, `deleted`)
SELECT 'root', '1234', '12345678901', 1
FROM DUAL
WHERE NOT EXISTS(SELECT username FROM `SystemUserEntity` WHERE `username` = 'root')

