#### 访问数据库
启动服务后，通过3307端口访问数据库
```
Server version: 5.7.32-log-ShardingSphere-Proxy 5.0.0-RC1
Copyright (c) 2000, 2014, Oracle and/or its affiliates. All rights reserved.
...
mysql> show databases;
+-------------+
| Database    |
+-------------+
| eshop_proxy |
+-------------+
1 row in set (0.07 sec)
```

#### 增
执行sql测试分库分表策略是否生效：
```
insert into `order`(order_id, user_id) values(1, 1), (2, 1), (3, 1), (4, 1), (5, 1), (6, 1), (7, 1), (8, 1), (9,1), (10, 1),(11, 1), (12, 1),(13, 1), (14,1), (15,1),(16,1), (17,2), (18, 2), (19, 2), (20, 2), (21, 2), (22, 2),(23, 2), (24, 2), (25, 2), (26, 2), (27, 2), (28, 2), (29,2), (30, 2), (31, 2), (32, 2);
```
查看日志：
```
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Logic SQL: insert into `order`(order_id, user_id) values(1, 1), (2, 1), (3, 1), (4, 1), (5, 1), (6, 1), (7, 1), (8, 1), (9,1), (10, 1),(11, 1), (12, 1),(13, 1), (14,1), (15,1),(16,1), (17,2), (18, 2), (19, 2), (20, 2), (21, 2), (22, 2),(23, 2), (24, 2), (25, 2), (26, 2), (27, 2), (28, 2), (29,2), (30, 2), (31, 2), (32, 2)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - SQLStatement: MySQLInsertStatement(setAssignment=Optional.empty, onDuplicateKeyColumns=Optional.empty)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_1`(order_id, user_id) values(1, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_2`(order_id, user_id) values(2, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_3`(order_id, user_id) values(3, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_4`(order_id, user_id) values(4, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_5`(order_id, user_id) values(5, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_6`(order_id, user_id) values(6, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_7`(order_id, user_id) values(7, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_8`(order_id, user_id) values(8, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_9`(order_id, user_id) values(9, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_10`(order_id, user_id) values(10, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_11`(order_id, user_id) values(11, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_12`(order_id, user_id) values(12, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_13`(order_id, user_id) values(13, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_14`(order_id, user_id) values(14, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_15`(order_id, user_id) values(15, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_1 ::: insert into `order_0`(order_id, user_id) values(16, 1)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_1`(order_id, user_id) values(17, 2)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_2`(order_id, user_id) values(18, 2)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_3`(order_id, user_id) values(19, 2)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_4`(order_id, user_id) values(20, 2)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_5`(order_id, user_id) values(21, 2)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_6`(order_id, user_id) values(22, 2)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_7`(order_id, user_id) values(23, 2)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_8`(order_id, user_id) values(24, 2)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_9`(order_id, user_id) values(25, 2)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_10`(order_id, user_id) values(26, 2)
[INFO ] 16:23:28.940 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_11`(order_id, user_id) values(27, 2)
[INFO ] 16:23:28.941 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_12`(order_id, user_id) values(28, 2)
[INFO ] 16:23:28.941 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_13`(order_id, user_id) values(29, 2)
[INFO ] 16:23:28.941 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_14`(order_id, user_id) values(30, 2)
[INFO ] 16:23:28.941 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_15`(order_id, user_id) values(31, 2)
[INFO ] 16:23:28.941 [ShardingSphere-Command-13] ShardingSphere-SQL - Actual SQL: ds_0 ::: insert into `order_0`(order_id, user_id) values(32, 2)
```
数据成功插入2个数据库，各16张数据库表中。

#### 删
确定order_id和user_id删除数据，可准确定位到对应数据库和表。
```
[INFO ] 16:54:58.049 [ShardingSphere-Command-7] ShardingSphere-SQL - Logic SQL: delete from `order` where order_id=10 and user_id=1
[INFO ] 16:54:58.050 [ShardingSphere-Command-7] ShardingSphere-SQL - SQLStatement: MySQLDeleteStatement(orderBy=Optional.empty, limit=Optional.empty)
[INFO ] 16:54:58.050 [ShardingSphere-Command-7] ShardingSphere-SQL - Actual SQL: ds_1 ::: delete from `order_10` where order_id=10 and user_id=1
```

#### 改
更新user_id为1的用户的订单更新时间为现在。从日志可以看出，直接通过user_id路由到了ds_1
```
[INFO ] 16:50:30.816 [ShardingSphere-Command-2] ShardingSphere-SQL - Logic SQL: update `order` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - SQLStatement: MySQLUpdateStatement(orderBy=Optional.empty, limit=Optional.empty)
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_0` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_1` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_2` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_3` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_4` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_5` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_6` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_7` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_8` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_9` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_10` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_11` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_12` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_13` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_14` set update_time=now() where user_id=1
[INFO ] 16:50:30.817 [ShardingSphere-Command-2] ShardingSphere-SQL - Actual SQL: ds_1 ::: update `order_15` set update_time=now() where user_id=1
```

#### 查
执行语句select * from `order` where order_id=15。无user_id，需要两个数据库都进行查询，但是根据order_id路由到了对应的数据库表，所以只要查两个表。
```
[INFO ] 16:52:35.902 [ShardingSphere-Command-5] ShardingSphere-SQL - Logic SQL: select * from `order` where order_id=15
[INFO ] 16:52:35.902 [ShardingSphere-Command-5] ShardingSphere-SQL - SQLStatement: MySQLSelectStatement(limit=Optional.empty, lock=Optional.empty)
[INFO ] 16:52:35.902 [ShardingSphere-Command-5] ShardingSphere-SQL - Actual SQL: ds_0 ::: select * from `order_15` where order_id=15
[INFO ] 16:52:35.902 [ShardingSphere-Command-5] ShardingSphere-SQL - Actual SQL: ds_1 ::: select * from `order_15` where order_id=15
```


