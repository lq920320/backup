# backup
个人常用代码备份

## windows git 升级版本
```
> git --version

// 2.17.1之前用git update
> git update

// 2.17.1之后用git update-git-for-windows
> git update-git-for-windows
```

## 快速解决 MySQL 死锁的问题

```sql
SELECT * FROM information_schema.INNODB_TRX;

KILL ${trx_mysql_thread_id};

-- 1、查询是否锁表 
show OPEN TABLES where In_use > 0;
-- 2、查询进程
show processlist   
-- 查询到相对应的进程===然后 kill    id

-- 补充：
-- 查看正在锁的事务
SELECT * FROM INFORMATION_SCHEMA.INNODB_LOCKS; 
-- 查看等待锁的事务
SELECT * FROM INFORMATION_SCHEMA.INNODB_LOCK_WAITS; 

```

## 关联表删除，`DELETE FROM` 与 `JOIN` 的结合使用

```sql
# 第一种方式：
DELETE T1
FROM T1
INNER JOIN T2 ON T1.key = T2.key
WHERE condition;

# 第二种方式：
DELETE FROM task_news a where exists(select 1 from temp_new b where a.ID=b.ID and b.UserID>0);
```

## 资源推荐

1. [生成好看的代码截图网站——Carbon](https://carbon.now.sh/)
1. [markdown编辑器推荐--Typora，所见即所写](https://www.typora.io/#)
1. [数据科学入门repo](https://github.com/virgili0/Virgilio/blob/master/zh-CN/README.md)
