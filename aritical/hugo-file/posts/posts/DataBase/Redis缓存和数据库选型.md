---
title: "Redis缓存和数据库区别"
date: 2021-04-25T09:58:02+08:00
draft: false
author: "SeaSoonKeun"
description: "Redis缓存和数据库区别"
tags: ["缓存"]
categories: ["Redis"]
toc: 
  auto: true

lightgallery: true
---
# Redis 作为缓存和数据库区别

![](https://raw.githubusercontent.com/SeaSoonKeun/Picture/main/Blog_Pic/redis%E7%BC%93%E5%AD%98.jpg)

## 什么是缓存：

	1. 数据“不重要”，**不是全量数据**
	2. 应该随着访问变化，**热数据**

缓存常见问题：

> 击穿
>
> 雪崩
>
> 穿透
>
> 一致性（双写）
>
> 技术是易于人的使用！
>
> 理论是极其复杂！

> 缓存：数据可以丢 急速！
>
> 数据库：数据绝对不能丢的 速度+持久性 掉电易失！

## 问题：

> 怎么随着业务变化，只保留热数据，因为内存大小是有限的（瓶颈）？

- 业务逻辑 —> 有限期 expire

- 业务运转 —> 业务的变化，淘汰冷数据 —> 置换算法

内存多大呢？如何限制？

> Redis 配置文件：

```bash
[root@localhost ~]# cat /etc/redis/6379.conf |egrep '^[a-zA-Z]|##'
## Generated by install_server.sh ##
导入基础配置
################################## INCLUDES ###################################

################################## MODULES #####################################
加载绝对路径下的扩展库文件，也可以手动加在启动命令后面 --loadmodule
loadmodule /opt/soft/redis/redisbloom.so
################################## NETWORK #####################################
绑定端口
bind 127.0.0.1
protected-mode yes
port 6379
tcp-backlog 511
timeout 0
tcp-keepalive 300
################################# TLS/SSL #####################################
################################# GENERAL 全局 #####################################
是否为后台守护模式
daemonize yes

supervised no
进程pid文件，判断程序是否在运行
pidfile /var/run/redis_6379.pid
日志级别
loglevel notice
日志目录
logfile /var/log/redis_6379.log
默认库
databases 16
always-show-logo yes
################################ SNAPSHOTTING  RDP ################################
save 900 1
save 300 10
save 60 10000
stop-writes-on-bgsave-error yes
rdbcompression yes
rdbchecksum yes
dbfilename dump.rdb
rdb-del-sync-files no
dir /var/lib/redis/6379
################################# REPLICATION 主从复制 #################################
replica-serve-stale-data yes
replica-read-only yes
repl-diskless-sync no
repl-diskless-sync-delay 5
repl-diskless-load disabled
repl-disable-tcp-nodelay no
replica-priority 100
############################### KEYS TRACKING #################################
################################## SECURITY 安全 ###################################
添加ACL users
重命名命令flushdb/flushall
rename-command CONFIG ""
acllog-max-len 128
################################### CLIENTS ####################################
最大允许链接数
# maxclients 10000
############################## MEMORY MANAGEMENT 内存管理 ################################
最大内存1-10G范围，太大后面数据持久化存储迁移成本很大
# MAXMEMORY POLICY
# maxmemory <bytes>
LRU Least Recently Used 最近最少使用算法
volatile（只针对有有效期的key）
# volatile-lru -> Evict using approximated LRU, only keys with an expire set.
# allkeys-lru -> Evict any key using approximated LRU.
LFU Least Frequency Used 最少使用置换算法
# volatile-lfu -> Evict using approximated LFU, only keys with an expire set.
# allkeys-lfu -> Evict any key using approximated LFU.
随机
# volatile-random -> Remove a random key having an expire set.
# allkeys-random -> Remove a random key, any key.
比较时间成本，复杂度太高
# volatile-ttl -> Remove the key with the nearest expire time (minor TTL)

# noeviction -> Don't evict anything, just return an error on write operations.
############################# LAZY FREEING ####################################
lazyfree-lazy-eviction no
lazyfree-lazy-expire no
lazyfree-lazy-server-del no
replica-lazy-flush no
lazyfree-lazy-user-del no
################################ THREADED I/O #################################
############################## APPEND ONLY MODE ###############################
appendonly no
appendfilename "appendonly.aof"
appendfsync everysec
no-appendfsync-on-rewrite no
auto-aof-rewrite-percentage 100
auto-aof-rewrite-min-size 64mb
aof-load-truncated yes
aof-use-rdb-preamble yes
################################ LUA SCRIPTING  ###############################
lua-time-limit 5000
################################ REDIS CLUSTER  ###############################
########################## CLUSTER DOCKER/NAT support  ########################
################################## SLOW LOG ###################################
slowlog-log-slower-than 10000
slowlog-max-len 128
################################ LATENCY MONITOR ##############################
latency-monitor-threshold 0
############################# EVENT NOTIFICATION ##############################
notify-keyspace-events ""
############################### GOPHER SERVER #################################
############################### ADVANCED CONFIG ###############################
hash-max-ziplist-entries 512
hash-max-ziplist-value 64
list-max-ziplist-size -2
list-compress-depth 0
set-max-intset-entries 512
zset-max-ziplist-entries 128
zset-max-ziplist-value 64
hll-sparse-max-bytes 3000
stream-node-max-bytes 4096
stream-node-max-entries 100
activerehashing yes
client-output-buffer-limit normal 0 0 0
client-output-buffer-limit replica 256mb 64mb 60
client-output-buffer-limit pubsub 32mb 8mb 60
hz 10
dynamic-hz yes
aof-rewrite-incremental-fsync yes
rdb-save-incremental-fsync yes
########################### ACTIVE DEFRAGMENTATION #######################
jemalloc-bg-thread yes
```

### 1. 页面置换算法解决淘汰冷数据问题

evict 驱逐 noeviction 不进行置换的

- LRU（Recently）最近时间

- LFU（Frequency）次数
- 如何选择看栈底，如果有大量配置了有效期，优先使用volatile，否则使用allkeys

### 2. 过期时间如何设置

### 1）倒计时：set key value [EX seconds|PX milliseconds] [NX|XX] [KEEPTTL] 

```bash
127.0.0.1:6379> set k1 111 ex 10
OK
127.0.0.1:6379> get k1
"111"
127.0.0.1:6379> ttl k1
(integer) 5
127.0.0.1:6379> ttl k1
(integer) 3
127.0.0.1:6379> ttl k1
(integer) 2
127.0.0.1:6379> ttl k1
(integer) -2
127.0.0.1:6379> get k1
(nil)
127.0.0.1:6379> set k1 111
OK
127.0.0.1:6379> ttl k1
(integer) -1
```

### 2）定时：EXPIREAT key timestamp

```bash
127.0.0.1:6379> set k1 111
OK
127.0.0.1:6379> EXPIREAT k1 1619379999
(integer) 1
127.0.0.1:6379> get k1
"111"
127.0.0.1:6379> ttl k1
(integer) 17591
```



`ttl`值的三个状态：-1 持久 -2 超时 

- 不会随着访问而延长有效期
- 重新写会重置有效期

**需要业务逻辑进行补全**

### 3. 过期淘汰的方式

Redis 的 key 有两种过期淘汰的方式：**被动方式、主动方式**。

被动过期：用户访问某个 key 的时候，key 被发现过期。

当然，被动方式过期对于那些永远也不会再次被访问的 key 并没有效果。不管怎么，这些 key 都应被过期淘汰，所以 Redis 周期性主动随机检查一部分被设置生存时间的 key，那些已经过期的 key 会被从 key 空间中删除。

Redis每秒执行10次下面的操作：

1. 从带有生存时间的 key 的集合中随机选 20 进行检查。
2. 删除所有过期的key。
3. 如20里面有超过25%的key过期，立刻继续执行步骤1。

这是一个狭义概率算法，我们假设我们选出来的样本 key 代表整个 key 空间，我们继续过期检查直到过期 key 的比例降到 25% 以下。

这意味着在任意时刻已经过期但还占用内存的 key 的数量，最多等于每秒最多写操作的四分之一。

**牺牲一部分内存，保证redis性能为王！！！**


