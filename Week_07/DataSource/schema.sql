CREATE SCHEMA eshop;
USE eshop;
CREATE TABLE `order`
(
    order_id       INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '订单ID',
    order_sn       VARCHAR(45)           DEFAULT NULL COMMENT '订单编号',
    customer_id    INT UNSIGNED          DEFAULT NULL COMMENT '下单人ID',
    address        VARCHAR(100)          DEFAULT NULL COMMENT '地址',
    seller_id      INT UNSIGNED          DEFAULT NULL COMMENT '商户ID',
    payment_method TINYINT               DEFAULT NULL COMMENT '支付方式：1现金，2余额，3网银，4支付宝，5微信',
    order_money    DECIMAL(8, 2)         DEFAULT NULL COMMENT '订单金额',
    order_status   TINYINT      NOT NULL DEFAULT 0 COMMENT '订单状态',
    create_time    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '下单时间',
    modified_time  TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最后修改时间',
    PRIMARY KEY (order_id)
) ENGINE = innodb COMMENT '订单主表';
INSERT INTO eshop.order(order_sn, customer_id, address, seller_id, payment_method, order_money, order_status, create_time, modified_time) VALUES ("ASDASDSADAS", 1999, "ADDRESS",2000, 0, 12, 0, DEFAULT, now(), now());
SELECT * FROM `order`;

