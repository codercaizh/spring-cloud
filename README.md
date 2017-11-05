# 一、笔记简介

本系列笔记分为了如下9个部分：

 - [SpringCloud微服务系列笔记(0)--笔记说明（已完成）](http://blog.csdn.net/qq_22152261/article/details/78450801)
 - [SpringCloud微服务系列笔记(1)--SpringBoot简单入门（已完成）](http://blog.csdn.net/qq_22152261/article/details/78450962)
 - SpringCloud微服务系列笔记(2)--Feign声明式REST客户端（正在进行）
 - SpringCloud微服务系列笔记(3)--Eureka服务发现（未完成）
 - SpringCloud微服务系列笔记(4)--Ribbon负载均衡（未完成）
 - SpringCloud微服务系列笔记(5)--Hystric断路器（未完成）
 - SpringCloud微服务系列笔记(6)--Zuul网关（未完成）
 - SpringCloud微服务系列笔记(7)--Config配置中心（未完成）
 - SpringCloud微服务系列笔记(8)--Sleuth全链路追踪（未完成）
 
这一系列笔记我会在业余时间慢慢更新。写这一系列笔记目的是对这一段时间学习Spring Cloud的总结，同时也方便后面进行回顾，大家也可以将此系列笔记当做简单的入门教程，为了确保内容的准确性，但凡引用的内容基本以官方文档为主。另外，本系列笔记均为个人总结体会，中间如果有任何错误或不当信息，请通过评论或下方联系方式进行指教，谢谢！


----------


# 二、开发环境

**下面链接均为官方文档地址或官方下载地址**


 - 操作系统：WIN10 64位 
 - JAVA版本：64位 JDK1.8
 - 开发工具IDE：[Spring Tool Suite-3.9.1.RELEASE](http://download.springsource.com/release/STS/3.9.1.RELEASE/dist/e4.7/spring-tool-suite-3.9.1.RELEASE-e4.7.1a-win32-x86_64.zip "官方下载地址")
 - 压测工具：[Apache-jmeter-3.3]( http://mirrors.hust.edu.cn/apache//jmeter/binaries/apache-jmeter-3.3.zip "官方下载地址")
 -  Spring Cloud版本：[Dalston.SR4](http://cloud.spring.io/spring-cloud-static/Dalston.SR4/ "官方文档地址")
 - Spring Boot版本： [1.5.8.RELEASE](https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/ "官方文档地址")

**Maven镜像仓库：**

```
<mirror>
    <id>nexus-163</id>
    <mirrorOf>*</mirrorOf>
    <name>Nexus 163</name>
    <url>http://mirrors.163.com/maven/repository/maven-public/</url>
</mirror>
```
推荐使用这个网易163的镜像源，速度快、更新及时。


----------


 


