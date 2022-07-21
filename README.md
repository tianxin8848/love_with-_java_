# 代码需求：

从某网站爬取qq号并且写入数据库中。



# 代码实现工具

1、数据库，

2、intelliJ IDEA



# 项目过程注意点：

1、request请求

2、数据库drive版本要正确，否者调试会报错，在实验过程中还得给数据释放”回滚“功能权限，

以上问题解决方案可自行google百度。



# 以下是数据库发生回滚的解决方案。

```
C:\Users\tianxin-user>mysql -u
mysql: [ERROR] mysql: option '-u' requires an argument.

C:\Users\tianxin-user>mysql -uroot -p
Enter password: ****
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 438
Server version: 8.0.22 MySQL Community Server - GPL

Copyright (c) 2000, 2020, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> select @@autocommit;
+--------------+
| @@autocommit |
+--------------+
|            1 |
+--------------+
1 row in set (0.00 sec)

mysql> set autocommit=0`;
    `> select @@autocommit;
    `> select @@autocommit;
    `>
    `> select @@autocommit;
    `> set autocommit=0`;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '`;
select @@autocommit;
select @@autocommit;

select @@autocommit;
set autocommi' at line 1
mysql> select @@autocommit;
+--------------+
| @@autocommit |
+--------------+
|            1 |
+--------------+
1 row in set (0.00 sec)

mysql> set autocommit=0`;
    `> select @@autocommit;
    `> select @@autocommit;
    `> set autocommit=0`;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '`;
select @@autocommit;
select @@autocommit;
set autocommit=0`' at line 1
mysql> set autocommit=0`;
    `> select @@autocommit;
    `> select @@autocommit;
    `> select @@autocommit;
    `> select @@autocommit;
    `> select @@autocommit;
    `> select @@autocommit;
    `> set autocommit=0`;
ERROR 1064 (42000): You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '`;
select @@autocommit;
select @@autocommit;
select @@autocommit;
select @@autoc' at line 1
mysql> set autocommit=0;
Query OK, 0 rows affected (0.00 sec)

mysql> select @@autocommit;
+--------------+
| @@autocommit |
+--------------+
|            0 |
+--------------+
1 row in set (0.00 sec)

mysql>
```
