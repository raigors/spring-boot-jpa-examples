-- 创建可重复执行的建表语句
-- CREATE TABLE IF NOT EXISTS
CREATE TABLE IF NOT EXISTS `SystemUserEntity`
(
    `id`                       bigint                               NOT NULL AUTO_INCREMENT,
    `password`                 char(100) COLLATE utf8mb4_general_ci NOT NULL COMMENT '密码',
    `create_by`                varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `create_date`              datetime                                DEFAULT NULL,
    `deleted`                  int                                     DEFAULT '0' COMMENT '改记录是否删除',
    `last_modified_by`         varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
    `last_modified_date`       datetime                                DEFAULT NULL,
    `note`                     varchar(100) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '备注',
    `preset`                   int                                     DEFAULT '0' COMMENT '是否为预置',
    `version`                  bigint                                  DEFAULT '0' COMMENT '改记录是否删除',
    `username`                 varchar(50) COLLATE utf8mb4_general_ci  DEFAULT NULL COMMENT '用户名',
    `account_expired_date`     datetime                                DEFAULT NULL COMMENT '账户没有过期',
    `account_locked_date`      datetime                                DEFAULT NULL COMMENT '账户没有被锁定',
    `credentials_expired_date` datetime                                DEFAULT NULL COMMENT '凭证没有过期',
    `enabled_date`             datetime                                DEFAULT NULL COMMENT '账号用没用启用',
    `phone`                    char(20) COLLATE utf8mb4_general_ci     DEFAULT NULL COMMENT '手机号码',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 45
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci;


