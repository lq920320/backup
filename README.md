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

```

## 资源推荐

1. [生成好看的代码截图网站——Carbon](https://carbon.now.sh/)
1. [markdown编辑器推荐--Typora，所见即所写](https://www.typora.io/#)
1. [数据科学入门repo](https://github.com/virgili0/Virgilio/blob/master/zh-CN/README.md)
