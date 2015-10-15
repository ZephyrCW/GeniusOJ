<font color="red">This is Chinese documentation. If you need English version, please send an issue to this repo. Your request will be added into the schedule immediately.</font>

# GeniusOJ Core Module技术文档

亲爱的开发者，欢迎访问GeniusOJ Core Module技术文档。

我们将会在这篇文档中向您介绍GeniusOJ Core Module是如何实现的，并简要介绍架构和技术。  
而具体的api等信息，我们将会在每个包中和javadoc中介绍。

## GeniusOJ Core Module在GeniusOJ System中扮演什么角色

GeniusOJ Core Module是GeniusOJ System的评测核心以及数据库核心。您编写的所有代码，都是由GeniusOJ Core Module进行收集、并执行评测脚本进行评测工作的。可以说，GeniusOJ Core Module是GeniusOJ System的最重要的部件。

## GeniusOJ Core Module开发约定

### 包名

__约定包名：对于GeniusOJ Core Module，我们采用以下包名：__  
```geniusoj.core.<子模块>.<功能>.<分类一级>.<分类二级>......```  
同时，对于GeniusOJ Core Module，我们要求：  
1、源文件UTF-8编码  
2、文件引用使用平台通用url格式  
3、数据库使用Hibernate框架  

---
### 代码风格

对于GeniusOJ Core Module以及GeniusOJ System，我们不对代码风格进行硬性要求。但我们建议您使用：  
[Google Java Coding Style Guide](http://google-styleguide.googlecode.com/svn/trunk/javaguide.html)  
它的中文版在：  
[Google Java代码风格说明](http://www.blogjava.net/zh-weir/archive/2014/02/08/409608.html)  
我们强烈建议所有向我们发送Pull Request的Github用户遵守这些代码风格要求。

## 项目架构说明

__由于GeniusOJ System正处于开发初期，我们目前做出的架构说明并不代表完成时的情况。__  
__如果有任何架构更新，我们将会立刻更新文档，一切信息以源代码而不是文档为准。__

截至目前，我们已经完成了对GeniusOJ Core Module的初步项目架构。此处，仅介绍Core Module的架构，其他Module的架构在其对应文档中说明。

> geniusoj.core.data  数据库支持（hibernate）、数据模型和全局数据存储
> > geniusoj.core.data.db  Hibernate数据库支持
> > > 此处提供的数据库支持按照以下方式进行组织：```geniusoj.core.data.db.<表名>```

> > geniusoj.core.data.model  数据模型  
> > geniusoj.core.data.global  全局静态数据存储

> geniusoj.core.judge  与评测有关的类

> > Working in progress...

> geniusoj.core.util  附加工具
> > 例如源代码安全检查工具、文件拷贝工具、附加文件解压缩工具等等。

<font color="red">以上包路径架构随时都会变更。</font>

## 特殊的类

在GeniusOJ Core Module中有一些特殊而重要的类，我们在下方更新关于它们的解释。

---
### CoreInit

路径：```geniusoj.core.CoreInit```   
功能：初始化Core Module  
用法：在tomcat容器启动后第一时间调用```CoreInit.initCore(CoreInitArgs)```

---
### GOJLog

路径：```geniusoj.core.util.GOJLog```  
功能：log打印
用法：调用```GOJLog.print(String)```和```GOJLog.println(String)```

Working in Progress...