---
title: "Linux7-firewalld配置"
date: 2021-05-06T09:58:02+08:00
draft: false
author: "SeaSoonKeun"
description: "Linux7-firewalld配置"
tags: ["Linux","Firewalld"]
categories: ["Linux"]
toc: 
  auto: true

lightgallery: true
---
# Linux7-firewalld配置

## 常用命令

1、查看防火墙状态    

```
systemctl status firewalld
```

2、关闭防火墙 

```
 systemctl stop firewalld
```

3、开启防火墙  

```
systemctl start firewalld
```

4、禁止防火墙开机自启动  

```
systemctl disable firewalld
```

5、设置防火墙开机自启动  

```
systemctl enable firewalld
```

6、查看防火墙已开放的端口列表(默认不开放任何端口)   

```
firewall-cmd –list-ports
```

7、开启80端口（允许80端口通过防火墙）

```
firewall-cmd --zone=public --add-port=80/tcp --permanent(永久生效)
```

8、更新防火墙规则  

```
firewall-cmd --reload
```

9、删除开放的端口  

```
firewall-cmd --zone=public  --remove-port=80/tcp  --permanent
```

10、查看8 0端口状态：

```
firewall-cmd --zone=public --query-port=80/tcp
```

11、只允许服务器192.168.1.1/24网段的3306端口能访问

```
firewall-cmd --permanent --add-rich-rule="rule family="ipv4" source address="192.168.1.1/24" port protocol="tcp" port="3306" accept"
```

## 一.前言

Centos7以上的发行版都试自带了firewalld防火墙的，firewalld去带了iptables防火墙。其原因是iptables的防火墙策略是交由内核层面的netfilter网络过滤器来处理的，而firewalld则是交由内核层面的nftables包过滤框架来处理。 相较于iptables防火墙而言，firewalld支持动态更新技术并加入了区域（zone）的概念。简单来说，区域就是firewalld预先准备了几套防火墙策略集合（策略模板），用户可以根据生产场景的不同而选择合适的策略集合，从而实现防火墙策略之间的快速切换。

区域对于 firewalld 来说是一大特色，但是对于我们使用Centos7一般是在服务器上，需要切换zone的需求比较少，所以本文不做介绍了，网上资料也比较多，大家可以去百度找找资料。

## 二.操作与配置

### 1.服务操作

启动服务：

```shell
systemctl start firewalld
```

> 这里不用担心启用了防火墙以后无法通过ssh远程，22端口默认加入了允许规则

停止服务：

```shell
systemctl stop firewalld
```

重启服务：

```shell
systemctl restart firewalld
```

查看服务状态：

```shell
systemctl status firewalld
```

### 2.配置文件说明

firewalld 存放配置文件有两个目录，`/usr/lib/firewalld` 和 `/etc/firewalld`，前者存放了一些默认的文件，后者主要是存放用户自定义的数据，所以我们添加的service或者rule都在后者下面进行。

`server` 文件夹存储服务数据，就是一组定义好的规则。

`zones` 存储区域规则

```
firewalld.conf` 默认配置文件，可以设置默认使用的区域，默认区域为 public，对应 zones目录下的 `public.xml
```

## 三.命令

这里需要首先说明的是，在执行命令时，如果没有带 `--permanent` 参数表示配置立即生效，但是不会对该配置进行存储，相当于重启服务器就会丢失。如果带上则会将配置存储到配置文件，，但是这种仅仅是将配置存储到文件，却并不会实时生效，需要执行 `firewall-cmd --reload` 命令重载配置才会生效。

### 1.重载防火墙配置

```shell
firewall-cmd --reload
```

### 2.查看防火墙运行状态

```shell
firewall-cmd --state
```

### 3.查看默认区域的设置

```shell
firewall-cmd --list-all
```

### 4.应急命令

```shell
firewall-cmd --panic-on  # 拒绝所有流量，远程连接会立即断开，只有本地能登陆
firewall-cmd --panic-off  # 取消应急模式，但需要重启firewalld后才可以远程ssh
firewall-cmd --query-panic  # 查看是否为应急模式
```

### 5.服务

```shell
firewall-cmd --add-service=<service name> #添加服务
firewall-cmd --remove-service=<service name> #移除服务
```

### 6.端口

```shell
firewall-cmd --add-port=<port>/<protocol> #添加端口/协议（TCP/UDP）
firewall-cmd --remove-port=<port>/<protocol> #移除端口/协议（TCP/UDP）
firewall-cmd --list-ports #查看开放的端口
```

### 7.协议

```shell
firewall-cmd --add-protocol=<protocol> # 允许协议 (例：icmp，即允许ping)
firewall-cmd --remove-protocol=<protocol> # 取消协议
firewall-cmd --list-protocols # 查看允许的协议
```

### 8.允许指定ip的所有流量

```shell
firewall-cmd --add-rich-rule="rule family="ipv4" source address="<ip>" accept"
```

例：

```shell
firewall-cmd --add-rich-rule="rule family="ipv4" source address="192.168.2.1" accept" # 表示允许来自192.168.2.1的所有流量
```

### 9.允许指定ip的指定协议

```shell
firewall-cmd --add-rich-rule="rule family="ipv4" source address="<ip>" protocol value="<protocol>" accept"
```

例：

```shell
firewall-cmd --add-rich-rule="rule family="ipv4" source address="192.168.2.208" protocol value="icmp" accept" # 允许192.168.2.208主机的icmp协议，即允许192.168.2.208主机ping
```

### 10.允许指定ip访问指定服务

```shell
firewall-cmd --add-rich-rule="rule family="ipv4" source address="<ip>" service name="<service name>" accept"
```

例：

```shell
firewall-cmd --add-rich-rule="rule family="ipv4" source address="192.168.2.208" service name="ssh" accept" # 允许192.168.2.208主机访问ssh服务
```

### 11.允许指定ip访问指定端口

```shell
firewall-cmd --add-rich-rule="rule family="ipv4" source address="<ip>" port protocol="<port protocol>" port="<port>" accept"
```

例：

```shell
firewall-cmd --add-rich-rule="rule family="ipv4" source address="192.168.2.1" port protocol="tcp" port="22" accept" # 允许192.168.2.1主机访问22端口
```

### 12.将指定ip改为网段

8-11 的各个命令都支持 `source address` 设置为网段，即这个网段的ip都是适配这个规则：

例如：

```shell
firewall-cmd --zone=drop --add-rich-rule="rule family="ipv4" source address="192.168.2.0/24" port protocol="tcp" port="22" accept"
```

表示允许192.168.2.0/24网段的主机访问22端口 。

### 13.禁止指定ip/网段

8-12 各个命令中，将 `accept` 设置为 `reject`表示拒绝，设置为 `drop`表示直接丢弃（会返回timeout连接超时）

例如：

```shell
firewall-cmd --zone=drop --add-rich-rule="rule family="ipv4" source address="192.168.2.0/24" port protocol="tcp" port="22" reject"
```

表示禁止192.168.2.0/24网段的主机访问22端口 。

## 四.参考资料

[firewalld防火墙详解](http://blog.51cto.com/andyxu/2137046) by xuad88.