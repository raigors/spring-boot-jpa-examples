-- 创建可重复执行的 SQL
-- INSERT INTO IF EXISTS 具体语法如下：
-- INSERT INTO table(field1, field2, fieldn) SELECT 'field1', 'field2', 'fieldn' FROM DUAL WHERE NOT EXISTS(SELECT field FROM table WHERE field = ?)

INSERT INTO `SystemUserEntity` (`username`, `password`, `phone`, `deleted`)
SELECT 'root', '1234', '12345678901', 1
FROM DUAL
WHERE NOT EXISTS(SELECT username FROM `SystemUserEntity` WHERE `username` = 'root')

