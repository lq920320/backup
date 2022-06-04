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

#### 2. VS Code 国内下载速度慢的解决方案

替换源文件域名地址为：`https://vscode.cdn.azure.cn/`

比如，原地址为：`https://az764295.vo.msecnd.net/stable/054a9295330880ed74ceaedda236253b4f39a335/VSCode-darwin-universal.zip`，
替换为：`https://vscode.cdn.azure.cn/stable/054a9295330880ed74ceaedda236253b4f39a335/VSCode-darwin-universal.zip`


## Intej IDEA IDE

#### 1. 多个文件多行展示

`settings -> Editor -> General -> Editor Tabs`，取消勾选 "show tabs in one row"。

#### 2. 文本自动折行显示，不是自动换行

**单个文件：** 这个操作只会对单个文件生效，不会全局生效

> IntelliJ IDEA -> View -> Active Editor -> Use Soft Wraps

**全局设置：**

选中 `Settings -> Editor -> General`，有一栏为 `Soft Wraps`，勾选 “soft wraps these files” 选项，可以根据自己的需求完善文件类型，如下为我的设置：

`*.md; *.txt; *.rst; *.adoc; *.java  `




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

## Windows 禁止执行脚本的解决

windows下 报错误 禁止运行脚本 ， 禁止脚本执行

原因：首次在计算机上启动 Windows PowerShell 时，现用执行策略很可能是 Restricted（默认设置）。

1 在 Windows PowerShell 中输入 `get-executionpolicy`  看输出执行策略是不是 `Restricted`；

2 输入 `set-executionpolicy remotesigned`  修改执行策略即可。

*注意：安全方面会收到一定的影响。*

## MacBook Pro（M1芯片） 遇到的问题

#### 1、触控栏部分失灵，我的是声音和屏幕亮度失灵，其他都是正常的，如何解决？

在 `访达 -> 应用工具 -> 实用工具 -> 活动监视器`，右上角搜索 `touch`，可以找到一项 `TouchBarServer`，双击打开，点击 `强制退出`，等候重启，此问题便解决了。

不得不说，**重启大法好！！！**

#### 2、重启 MySQL 服务

系统更新之后，好像会把 mysql 服务给关掉，mysql 默认安装地址是 `个人\磁盘\usr\local\mysql\support-files`，命令如下：

```
# 启动MySQL服务
sudo ./usr/local/mysql/support-files/mysql.server start

# 停止MySQL服务
sudo ./usr/local/mysql/support-files/mysql.server stop

# 重启MySQL服务
sudo ./usr/local/mysql/support-files/mysql.server restart
```


## Gradle

#### 1、lombok 引用失败，导致一致编译不通过，找不到符号 `.getXxx()`

**弃用的方式**

```
compile('org.projectlombok:lombok:1.18.2)
```

如果仍使用该方式, 在构建项目的时候会出现如下信息

```
The following annotation processors were detected on the compile classpath: 'lombok.launch.AnnotationProcessorHider$AnnotationProcessor' 
Detecting annotation processors on the compile classpath is deprecated and Gradle 5.0 will ignore them.
Please add them to the annotation processor path instead. 
If you did not intend to use annotation processors, 
you can use the '-proc:none' compiler argument to ignore them.
```

在 stackoverflow上相关帖子 里面提及的方式也是错误的:

```
compileOnly('org.projectlombok:lombok:1.16.20') 
annotationProcessor 'org.projectlombok:lombok:1.16.20'
```

官方推荐的方式
```
annotationProcessor 'org.projectlombok:lombok:1.18.2'
compileOnly 'org.projectlombok:lombok:1.18.2'
testAnnotationProcessor 'org.projectlombok:lombok:1.18.2'
testCompileOnly 'org.projectlombok:lombok:1.18.2'
```

或者使用gradle lombok插件

```
repositories {
    mavenCentral()
}

plugins {
    id 'net.ltgt.apt' version '0.10'
}

dependencies {
    compileOnly 'org.projectlombok:lombok:1.18.2'

    apt "org.projectlombok:lombok:1.18.2"
}
```

**参考链接**： https://www.orchome.com/1615

## Docker 命令

### 1、基础命令

构建一个镜像：
```
docker build -t <Tag>:<Version> . 
```
运行一个镜像：
```
docker run -p <CONTAINER_PORT>:<SERVER_PORT> --name <CONTAINER_NAME> <Tag>:<Version>

# 设置时区运行
docker run -e TZ=Asia/Shanghai -p <CONTAINER_PORT>:<SERVER_PORT> --name <CONTAINER_NAME> <Tag>:<Version>
```
启动一个容器：
```
docker start <CONTAINER_ID>
```
停止一个容器：
```
docker stop <CONTAINER_ID>
```
进入到运行中的容器里：
```
docker exec -it <CONTAINER_ID> /bin/bash
```

## 工具/中间件类的问题

### Elasticsearch

#### 1、Elasticsearch 移除 type 之后的新姿势

随着 7.0 版本的即将发布，type 的移除也是越来越近了，在 6.0 的时候，已经默认只能支持一个索引一个 type 了，7.0 版本新增了一个参数 `include_type_name` ，即让所有的 API 是 type 相关的，这个参数在 7.0 默认是 true，不过在 8.0 的时候，会默认改成 false，也就是不包含 type 信息了，这个是 type 用于移除的一个开关。

让我们看看最新的使用姿势吧，当 `include_type_name` 参数设置成 false 后：
```
索引操作：PUT {index}/{type}/{id}需要修改成PUT {index}/_doc/{id}
Mapping 操作：PUT {index}/{type}/_mapping 则变成 PUT {index}/_mapping
所有增删改查搜索操作返回结果里面的关键字 _type 都将被移除
父子关系使用 join 字段来构建
```

```
#创建索引
PUT twitter
{
  "mappings": {
    "_doc": {
      "properties": {
        "type": { "type": "keyword" }, 
        "name": { "type": "text" },
        "user_name": { "type": "keyword" },
        "email": { "type": "keyword" },
        "content": { "type": "text" },
        "tweeted_at": { "type": "date" }
      }
    }
  }
}

#修改索引
PUT twitter/_doc/user-kimchy
{
  "type": "user", 
  "name": "Shay Banon",
  "user_name": "kimchy",
  "email": "shay@kimchy.com"
}

#搜索
GET twitter/_search
{
  "query": {
    "bool": {
      "must": {
        "match": {
          "user_name": "kimchy"
        }
      },
      "filter": {
        "match": {
          "type": "tweet" 
        }
      }
    }
  }
}

#重建索引
POST _reindex
{
  "source": {
    "index": "twitter"
  },
  "dest": {
    "index": "new_twitter"
  }
}
```
链接：https://elasticsearch.cn/article/601


## 资源推荐

1. [生成好看的代码截图网站——Carbon](https://carbon.now.sh/)
1. [markdown编辑器推荐--Typora，所见即所写](https://www.typora.io/#)
1. [数据科学入门repo](https://github.com/virgili0/Virgilio/blob/master/zh-CN/README.md)
1. [Go语言中文网](https://studygolang.com/dl)
1. [极客导航](https://geekdocs.cn/)
1. [现代JS教程](https://javascript.info/)
1. [现代JS教程中文版](https://zh.javascript.info/)

## 工具汇总
#### 插件篇

**IntelliJ IDEA**

- Free Mybatis plugin ：帮助你在 Mapper.java 与 mapper.xml 中方便跳转
- Lombok : 减少代码量
- .ignore : 帮你生成 ignore 文件
- codota : 人工智能帮你写代码【Install on IntelliJ and Android Studio to get advanced Java code completions】
- Alibaba Java Coding Guidelines : 代码规范扫描插件
- SequenceDiagram : 展示调用时序图，参考链接，https://juejin.im/post/6887719053931053064
- CamelCase : 转换你的驼峰以及蛇型命名
- Statistic : 有了这个插件之后你可以非常直观地看到你的项目中所有类型的文件的信息比如数量、大小等等，可以帮助你更好地了解你们的项目。
- treer : 生成项目的目录树，可以通过 `npm install -g treer` 安装，不过得允许系统运行脚本。

**VS code**

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
- https://www.toyaml.com/index.html : yaml 格式与 properties 格式的相互转换工具
- https://regex101.com/ : 正则表达式测试工具，可以看到执行步数
- https://readme.so/ : The easiest way to create a README，方便又实用
- https://chrome.zzzmh.cn/ : Chrome插件下载中心，无需科学上网

#### 项目推荐

- dayjs，2kb 的时间格式化包：https://github.com/iamkun/dayjs
- lodash，工具包：https://github.com/lodash/lodash 、https://lodash.com/docs
- Git 飞行规则：https://github.com/k88hudson/git-flight-rules/blob/master/README_zh-CN.md
- 黑客法则定律大全：https://github.com/nusr/hacker-laws-zh
- 开发人员学习资料：https://github.com/developer-learning
- 现代 JS 教程地址：https://github.com/javascript-tutorial/en.javascript.info/tree/master








