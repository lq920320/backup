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

## VS Code IDE
#### 1. 窗口打开多个文件设置

**方法1**：路径C:\Users\admin\AppData\Roaming\Code\User下的settings.json添加一条配置："workbench.editor.enablePreview": false。

**方法2**：文件 -> 首选项 -> 设置，搜索“preview”，把“Workbench > Ediotor: Enable PreView”的勾选去掉。注意“用户”和“工作区”确保都去掉了勾选。

## Maven build 的问题
如何隐藏 `mvn install` 过程中的 progress 展示？
```
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/maven-parent/27/maven-parent-27.pom
Progress (1): 4.1/41 kB
Progress (1): 8.2/41 kB
Progress (1): 12/41 kB 
Progress (1): 16/41 kB
Progress (1): 20/41 kB
Progress (1): 25/41 kB
Progress (1): 29/41 kB
Progress (1): 33/41 kB
Progress (1): 37/41 kB
Progress (1): 41 kB   
```
`mvn -B ..` 或者 `mvn --batch-mode ...`即可。

[stackoverflow地址](https://stackoverflow.com/questions/21638697/disable-maven-download-progress-indication)

## vue 项目中展示 markdown 文件内容

使用插件 [`vue-markdown-loader`](https://github.com/QingWei-Li/vue-markdown-loader)。

但是有个问题，对于 markdown 中 table 的样式支持得不是很好，于是强制设置 scss 样式，`/deep/` 这种方式会报错，最新的方式应该是 `::v-deep` 。

> 在vue项目中使用/deep/  来强制修改样式     
>    现在      
> 使用::v-deep 来修改样式     
> 原因，现在scss中会报loader错误


## 资源推荐

1. [生成好看的代码截图网站——Carbon](https://carbon.now.sh/)
1. [markdown编辑器推荐--Typora，所见即所写](https://www.typora.io/#)
1. [数据科学入门repo](https://github.com/virgili0/Virgilio/blob/master/zh-CN/README.md)

## 工具汇总
#### 插件篇

- Free Mybatis plugin ：帮助你在 Mapper.java 与 mapper.xml 中方便跳转
- Lombok : 减少代码量
- .ignore : 帮你生成 ignore 文件
- codota : 人工智能帮你写代码【Install on IntelliJ and Android Studio to get advanced Java code completions】
- Alibaba Java Coding Guidelines : 代码规范扫描插件
- SequenceDiagram : 展示调用时序图，参考链接，https://juejin.im/post/6887719053931053064

#### 网站在线工具篇

- https://www.cmd5.com/  : md5 的加密解密
- https://regexper.com/#%2F%5B0-9%5D%5Ba-zA-Z%5D%5B0-9A-Za-z%5D%7B6%2C%7D%2F  : 可视化你的正则表达式
- https://www.json.cn/ :  Json 格式化
- https://codeif.xinke.org.cn/#code : 帮助你命名你的变量
- https://squoosh.app/ : 在线压缩图片
- https://jinaconvert.com/cn/ : 图片在线转换，将您的图片转换成多种图片格式。JPG, PNG, GIF, BMP, TIFF, ICO, SVG和更多图片格式
- https://microsoft.github.io/TypeSearch/ : 搜索 TypeScript 的库
- https://caniuse.com/# : 兼容性搜索
- https://www.processon.com/ : 在线的流程图工具
- http://jsoneditoronline.org/ : 在线的 Json 编辑工具
- https://www.charlesproxy.com/ : Charles，代理工具，不过也是个抓包神器
- http://www.jq22.com/textDifference : 在线文本比较工具
- https://sourceforge.net/projects/diffuse/ : 代码比较工具，可下载
- https://www.typora.io/ : markdown 文本编辑工具，颜值贼高
- https://www.52doutu.cn/maker/1/?order=timedown : DouTu 表情包在线制作工具
- https://carbon.now.sh/ : 美化你的代码片段，生成代码片段图片
- https://www.pppet.net/ ：corn 表达式在线生成工具

#### 项目推荐

- dayjs，2kb 的时间格式化包：https://github.com/iamkun/dayjs
- lodash，工具包：https://github.com/lodash/lodash 、https://lodash.com/docs
- Git 飞行规则：https://github.com/k88hudson/git-flight-rules/blob/master/README_zh-CN.md
- 黑客法则定律大全：https://github.com/nusr/hacker-laws-zh
- 开发人员学习资料：https://github.com/developer-learning








