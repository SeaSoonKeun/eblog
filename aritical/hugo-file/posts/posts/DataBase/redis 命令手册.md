---
title: "redis命令手册"
date: 2021-04-24T17:30:02+08:00
draft: false
author: "SeaSoonKeun"
description: "redis命令手册"
tags: ["Redis"]
categories: ["Redis"]
toc: 
  auto: true

lightgallery: true
---
# redis 命令手册



## 命令目录(使用 CTRL + F 快速查找)：

- Key（键）
  - [DEL](https://www.redis.com.cn/commands/del.html)
  - [DUMP](https://www.redis.com.cn/commands/dump.html)
  - [EXISTS](https://www.redis.com.cn/commands/exists.html)
  - [EXPIRE](https://www.redis.com.cn/commands/expire.html)
  - [EXPIREAT](https://www.redis.com.cn/commands/expireat.html)
  - [KEYS](https://www.redis.com.cn/commands/keys.html)
  - [MIGRATE](https://www.redis.com.cn/commands/migrate.html)
  - [MOVE](https://www.redis.com.cn/commands/move.html)
  - [OBJECT](https://www.redis.com.cn/commands/object.html)
  - [PERSIST](https://www.redis.com.cn/commands/persist.html)
  - [PEXPIRE](https://www.redis.com.cn/commands/pexpire.html)
  - [PEXPIREAT](https://www.redis.com.cn/commands/pexpireat.html)
  - [PTTL](https://www.redis.com.cn/commands/pttl.html)
  - [RANDOMKEY](https://www.redis.com.cn/commands/randomkey.html)
  - [RENAME](https://www.redis.com.cn/commands/rename.html)
  - [RENAMENX](https://www.redis.com.cn/commands/renamenx.html)
  - [RESTORE](https://www.redis.com.cn/commands/restore.html)
  - [SORT](https://www.redis.com.cn/commands/sort.html)
  - [TTL](https://www.redis.com.cn/commands/ttl.html)
  - [TYPE](https://www.redis.com.cn/commands/type.html)
  - [SCAN](https://www.redis.com.cn/commands/scan.html)

- String（字符串）
  - [APPEND](https://www.redis.com.cn/commands/append.html)
  - [BITCOUNT](https://www.redis.com.cn/commands/bitcount.html)
  - [BITOP](https://www.redis.com.cn/commands/bitop.html)
  - [DECR](https://www.redis.com.cn/commands/decr.html)
  - [DECRBY](https://www.redis.com.cn/commands/decrby.html)
  - [GET](https://www.redis.com.cn/commands/get.html)
  - [GETBIT](https://www.redis.com.cn/commands/getbit.html)
  - [GETRANGE](https://www.redis.com.cn/commands/getrange.html)
  - [GETSET](https://www.redis.com.cn/commands/getset.html)
  - [INCR](https://www.redis.com.cn/commands/incr.html)
  - [INCRBY](https://www.redis.com.cn/commands/incrby.html)
  - [INCRBYFLOAT](https://www.redis.com.cn/commands/incrbyfloat.html)
  - [MGET](https://www.redis.com.cn/commands/mget.html)
  - [MSET](https://www.redis.com.cn/commands/mset.html)
  - [MSETNX](https://www.redis.com.cn/commands/msetnx.html)
  - [PSETEX](https://www.redis.com.cn/commands/psetex.html)
  - [SET](https://www.redis.com.cn/commands/set.html)
  - [SETBIT](https://www.redis.com.cn/commands/setbit.html)
  - [SETEX](https://www.redis.com.cn/commands/setex.html)
  - [SETNX](https://www.redis.com.cn/commands/setnx.html)
  - [SETRANGE](https://www.redis.com.cn/commands/setrange.html)
  - [STRLEN](https://www.redis.com.cn/commands/strlen.html)

- Hash（哈希表）
  - [HDEL](https://www.redis.com.cn/commands/hdel.html)
  - [HEXISTS](https://www.redis.com.cn/commands/hexists.html)
  - [HGET](https://www.redis.com.cn/commands/hget.html)
  - [HGETALL](https://www.redis.com.cn/commands/hgetall.html)
  - [HINCRBY](https://www.redis.com.cn/commands/hincrby.html)
  - [HINCRBYFLOAT](https://www.redis.com.cn/commands/hincrbyfloat.html)
  - [HKEYS](https://www.redis.com.cn/commands/hkeys.html)
  - [HLEN](https://www.redis.com.cn/commands/hlen.html)
  - [HMGET](https://www.redis.com.cn/commands/hmget.html)
  - [HMSET](https://www.redis.com.cn/commands/hmset.html)
  - [HSET](https://www.redis.com.cn/commands/hset.html)
  - [HSETNX](https://www.redis.com.cn/commands/hsetnx.html)
  - [HVALS](https://www.redis.com.cn/commands/hvals.html)
  - [HSCAN](https://www.redis.com.cn/commands/hscan.html)

- List（列表）
  - [BLPOP](https://www.redis.com.cn/commands/blpop.html)
  - [BRPOP](https://www.redis.com.cn/commands/brpop.html)
  - [BRPOPLPUSH](https://www.redis.com.cn/commands/brpoplpush.html)
  - [LINDEX](https://www.redis.com.cn/commands/lindex.html)
  - [LINSERT](https://www.redis.com.cn/commands/linsert.html)
  - [LLEN](https://www.redis.com.cn/commands/llen.html)
  - [LPOP](https://www.redis.com.cn/commands/lpop.html)
  - [LPUSH](https://www.redis.com.cn/commands/lpush.html)
  - [LPUSHX](https://www.redis.com.cn/commands/lpushx.html)
  - [LRANGE](https://www.redis.com.cn/commands/lrange.html)
  - [LREM](https://www.redis.com.cn/commands/lrem.html)
  - [LSET](https://www.redis.com.cn/commands/lset.html)
  - [LTRIM](https://www.redis.com.cn/commands/ltrim.html)
  - [RPOP](https://www.redis.com.cn/commands/rpop.html)
  - [RPOPLPUSH](https://www.redis.com.cn/commands/rpoplpush.html)
  - [RPUSH](https://www.redis.com.cn/commands/rpush.html)
  - [RPUSHX](https://www.redis.com.cn/commands/rpushx.html)

- Set（集合）
  - [SADD](https://www.redis.com.cn/commands/sadd.html)
  - [SCARD](https://www.redis.com.cn/commands/scard.html)
  - [SDIFF](https://www.redis.com.cn/commands/sdiff.html)
  - [SDIFFSTORE](https://www.redis.com.cn/commands/sdiffstore.html)
  - [SINTER](https://www.redis.com.cn/commands/sinter.html)
  - [SINTERSTORE](https://www.redis.com.cn/commands/sinterstore.html)
  - [SISMEMBER](https://www.redis.com.cn/commands/sismember.html)
  - [SMEMBERS](https://www.redis.com.cn/commands/smembers.html)
  - [SMOVE](https://www.redis.com.cn/commands/smove.html)
  - [SPOP](https://www.redis.com.cn/commands/spop.html)
  - [SRANDMEMBER](https://www.redis.com.cn/commands/srandmember.html)
  - [SREM](https://www.redis.com.cn/commands/srem.html)
  - [SUNION](https://www.redis.com.cn/commands/sunion.html)
  - [SUNIONSTORE](https://www.redis.com.cn/commands/sunionstore.html)
  - [SSCAN](https://www.redis.com.cn/commands/sscan.html)

- SortedSet（有序集合）
  - [ZADD](https://www.redis.com.cn/commands/zadd.html)
  - [ZCARD](https://www.redis.com.cn/commands/zcard.html)
  - [ZCOUNT](https://www.redis.com.cn/commands/zcount.html)
  - [ZINCRBY](https://www.redis.com.cn/commands/zincrby.html)
  - [ZRANGE](https://www.redis.com.cn/commands/zrange.html)
  - [ZRANGEBYSCORE](https://www.redis.com.cn/commands/zrangebyscore.html)
  - [ZRANK](https://www.redis.com.cn/commands/zrank.html)
  - [ZREM](https://www.redis.com.cn/commands/zrem.html)
  - [ZREMRANGEBYRANK](https://www.redis.com.cn/commands/zremrangebyrank.html)
  - [ZREMRANGEBYSCORE](https://www.redis.com.cn/commands/zremrangebyscore.html)
  - [ZREVRANGE](https://www.redis.com.cn/commands/zrevrange.html)
  - [ZREVRANGEBYSCORE](https://www.redis.com.cn/commands/zrevrangebyscore.html)
  - [ZREVRANK](https://www.redis.com.cn/commands/zrevrank.html)
  - [ZSCORE](https://www.redis.com.cn/commands/zscore.html)
  - [ZUNIONSTORE](https://www.redis.com.cn/commands/zunionstore.html)
  - [ZINTERSTORE](https://www.redis.com.cn/commands/zinterstore.html)
  - [ZSCAN](https://www.redis.com.cn/commands/zscan.html)

- Pub/Sub（发布/订阅）
  - [PSUBSCRIBE](https://www.redis.com.cn/commands/psubscribe.html)
  - [PUBLISH](https://www.redis.com.cn/commands/publish.html)
  - [PUBSUB](https://www.redis.com.cn/commands/pubsub.html)
  - [PUNSUBSCRIBE](https://www.redis.com.cn/commands/punsubscribe.html)
  - [SUBSCRIBE](https://www.redis.com.cn/commands/subscribe.html)
  - [UNSUBSCRIBE](https://www.redis.com.cn/commands/unsubscribe.html)

- Transaction（事务）
  - [DISCARD](https://www.redis.com.cn/commands/discard.html)
  - [EXEC](https://www.redis.com.cn/commands/exec.html)
  - [MULTI](https://www.redis.com.cn/commands/multi.html)
  - [UNWATCH](https://www.redis.com.cn/commands/unwatch.html)
  - [WATCH](https://www.redis.com.cn/commands/watch.html)

- Script（脚本）
  - [EVAL](https://www.redis.com.cn/commands/eval.html)
  - [EVALSHA](https://www.redis.com.cn/commands/evalsha.html)
  - [SCRIPT EXISTS](https://www.redis.com.cn/commands/script-exists.html)
  - [SCRIPT FLUSH](https://www.redis.com.cn/commands/script-flush.html)
  - [SCRIPT KILL](https://www.redis.com.cn/commands/script-kill.html)
  - [SCRIPT LOAD](https://www.redis.com.cn/commands/script-load.html)

- Connection（连接）
  - [AUTH](https://www.redis.com.cn/commands/auth.html)
  - [ECHO](https://www.redis.com.cn/commands/echo.html)
  - [PING](https://www.redis.com.cn/commands/ping.html)
  - [QUIT](https://www.redis.com.cn/commands/quit.html)
  - [SELECT](https://www.redis.com.cn/commands/select.html)

- Server（服务器）
  - [BGREWRITEAOF](https://www.redis.com.cn/commands/bgrewriteaof.html)
  - [BGSAVE](https://www.redis.com.cn/commands/bgsave.html)
  - [CLIENT GETNAME](https://www.redis.com.cn/commands/client-getname.html)
  - [CLIENT KILL](https://www.redis.com.cn/commands/client-kill.html)
  - [CLIENT LIST](https://www.redis.com.cn/commands/client-list.html)
  - [CLIENT SETNAME](https://www.redis.com.cn/commands/client-setname.html)
  - [CONFIG GET](https://www.redis.com.cn/commands/config-get.html)
  - [CONFIG RESETSTAT](https://www.redis.com.cn/commands/config-resetstat.html)
  - [CONFIG REWRITE](https://www.redis.com.cn/commands/config-rewrite.html)
  - [CONFIG SET](https://www.redis.com.cn/commands/config-set.html)
  - [DBSIZE](https://www.redis.com.cn/commands/dbsize.html)
  - [DEBUG OBJECT](https://www.redis.com.cn/commands/debug-object.html)
  - [DEBUG SEGFAULT](https://www.redis.com.cn/commands/debug-segfault.html)
  - [FLUSHALL](https://www.redis.com.cn/commands/flushall.html)
  - [FLUSHDB](https://www.redis.com.cn/commands/flushdb.html)
  - [INFO](https://www.redis.com.cn/commands/info.html)
  - [LASTSAVE](https://www.redis.com.cn/commands/lastsave.html)
  - [MONITOR](https://www.redis.com.cn/commands/monitor.html)
  - [PSYNC](https://www.redis.com.cn/commands/psync.html)
  - [SAVE](https://www.redis.com.cn/commands/save.html)
  - [SHUTDOWN](https://www.redis.com.cn/commands/shutdown.html)
  - [SLAVEOF](https://www.redis.com.cn/commands/slaveof.html)
  - [SLOWLOG](https://www.redis.com.cn/commands/slowlog.html)
  - [SYNC](https://www.redis.com.cn/commands/sync.html)
  - [TIME](https://www.redis.com.cn/commands/time.html)



## 文档

- 键空间通知（keyspace notification）
  - [功能概览](https://www.redis.com.cn/topics/notifications.html#id1)
  - [事件的类型](https://www.redis.com.cn/topics/notifications.html#id2)
  - [配置](https://www.redis.com.cn/topics/notifications.html#id3)
  - [命令产生的通知](https://www.redis.com.cn/topics/notifications.html#id4)
  - [过期通知的发送时间](https://www.redis.com.cn/topics/notifications.html#id5)

- 事务（transaction）
  - [用法](https://www.redis.com.cn/topics/transaction.html#id1)
  - [事务中的错误](https://www.redis.com.cn/topics/transaction.html#id2)
  - [为什么 Redis 不支持回滚（roll back）](https://www.redis.com.cn/topics/transaction.html#redis-roll-back)
  - [放弃事务](https://www.redis.com.cn/topics/transaction.html#id3)
  - [使用 check-and-set 操作实现乐观锁](https://www.redis.com.cn/topics/transaction.html#check-and-set)
  - [了解 WATCH](https://www.redis.com.cn/topics/transaction.html#watch)
  - [使用 WATCH 实现 ZPOP](https://www.redis.com.cn/topics/transaction.html#watch-zpop)
  - [Redis 脚本和事务](https://www.redis.com.cn/topics/transaction.html#redis)

- 发布与订阅（pub/sub）
  - [信息的格式](https://www.redis.com.cn/topics/pubsub.html#id2)
  - [订阅模式](https://www.redis.com.cn/topics/pubsub.html#id3)
  - [通过频道和模式接收同一条信息](https://www.redis.com.cn/topics/pubsub.html#id4)
  - [订阅总数](https://www.redis.com.cn/topics/pubsub.html#id5)
  - [编程示例](https://www.redis.com.cn/topics/pubsub.html#id6)
  - [客户端库实现提示](https://www.redis.com.cn/topics/pubsub.html#id8)

- 复制（Replication）
  - [复制功能的运作原理](https://www.redis.com.cn/topics/replication.html#id1)
  - [部分重同步](https://www.redis.com.cn/topics/replication.html#id2)
  - [配置](https://www.redis.com.cn/topics/replication.html#id3)
  - [只读从服务器](https://www.redis.com.cn/topics/replication.html#id4)
  - [从服务器相关配置](https://www.redis.com.cn/topics/replication.html#id5)
  - [主服务器只在有至少 N 个从服务器的情况下，才执行写操作](https://www.redis.com.cn/topics/replication.html#n)

- 通信协议（protocol）
  - [网络层](https://www.redis.com.cn/topics/protocol.html#id1)
  - [请求](https://www.redis.com.cn/topics/protocol.html#id2)
  - [新版统一请求协议](https://www.redis.com.cn/topics/protocol.html#id3)
  - [回复](https://www.redis.com.cn/topics/protocol.html#id4)
  - [状态回复](https://www.redis.com.cn/topics/protocol.html#id5)
  - [错误回复](https://www.redis.com.cn/topics/protocol.html#id6)
  - [整数回复](https://www.redis.com.cn/topics/protocol.html#id7)
  - [批量回复](https://www.redis.com.cn/topics/protocol.html#id8)
  - [多条批量回复](https://www.redis.com.cn/topics/protocol.html#id9)
  - [多条批量回复中的空元素](https://www.redis.com.cn/topics/protocol.html#id10)
  - [多命令和流水线](https://www.redis.com.cn/topics/protocol.html#id11)
  - [内联命令](https://www.redis.com.cn/topics/protocol.html#id12)
  - [高性能 Redis 协议分析器](https://www.redis.com.cn/topics/protocol.html#redis)

- 持久化（persistence）
  - [Redis 持久化](https://www.redis.com.cn/topics/persistence.html#redis)
  - [RDB 的优点](https://www.redis.com.cn/topics/persistence.html#rdb)
  - [RDB 的缺点](https://www.redis.com.cn/topics/persistence.html#id3)
  - [AOF 的优点](https://www.redis.com.cn/topics/persistence.html#aof)
  - [AOF 的缺点](https://www.redis.com.cn/topics/persistence.html#id4)
  - [RDB 和 AOF ，我应该用哪一个？](https://www.redis.com.cn/topics/persistence.html#rdb-aof)
  - [RDB 快照](https://www.redis.com.cn/topics/persistence.html#id5)
  - [快照的运作方式](https://www.redis.com.cn/topics/persistence.html#id6)
  - [只进行追加操作的文件（append-only file，AOF）](https://www.redis.com.cn/topics/persistence.html#append-only-file-aof)
  - [AOF 重写](https://www.redis.com.cn/topics/persistence.html#id7)
  - [AOF 有多耐久？](https://www.redis.com.cn/topics/persistence.html#id8)
  - [如果 AOF 文件出错了，怎么办？](https://www.redis.com.cn/topics/persistence.html#id9)
  - [AOF 的运作方式](https://www.redis.com.cn/topics/persistence.html#id10)
  - [怎么从 RDB 持久化切换到 AOF 持久化](https://www.redis.com.cn/topics/persistence.html#id11)
  - [RDB 和 AOF 之间的相互作用](https://www.redis.com.cn/topics/persistence.html#id12)
  - [备份 Redis 数据](https://www.redis.com.cn/topics/persistence.html#id13)
  - [容灾备份](https://www.redis.com.cn/topics/persistence.html#id14)

- Sentinel
  - [获取 Sentinel](https://www.redis.com.cn/topics/sentinel.html#id2)
  - [启动 Sentinel](https://www.redis.com.cn/topics/sentinel.html#id3)
  - [配置 Sentinel](https://www.redis.com.cn/topics/sentinel.html#id4)
  - [主观下线和客观下线](https://www.redis.com.cn/topics/sentinel.html#id5)
  - [每个 Sentinel 都需要定期执行的任务](https://www.redis.com.cn/topics/sentinel.html#id6)
  - [自动发现 Sentinel 和从服务器](https://www.redis.com.cn/topics/sentinel.html#id7)
  - [Sentinel API](https://www.redis.com.cn/topics/sentinel.html#sentinel-api)
  - [故障转移](https://www.redis.com.cn/topics/sentinel.html#id10)
  - [TILT 模式](https://www.redis.com.cn/topics/sentinel.html#tilt)
  - [处理 `-BUSY` 状态](https://www.redis.com.cn/topics/sentinel.html#busy)
  - [Sentinel 的客户端实现](https://www.redis.com.cn/topics/sentinel.html#id14)

- 集群教程
  - [集群简介](https://www.redis.com.cn/topics/cluster-tutorial.html#id2)
  - [Redis 集群数据共享](https://www.redis.com.cn/topics/cluster-tutorial.html#id3)
  - [Redis 集群中的主从复制](https://www.redis.com.cn/topics/cluster-tutorial.html#id4)
  - [Redis 集群的一致性保证（guarantee）](https://www.redis.com.cn/topics/cluster-tutorial.html#redis-guarantee)
  - [创建并使用 Redis 集群](https://www.redis.com.cn/topics/cluster-tutorial.html#id5)
  - [创建集群](https://www.redis.com.cn/topics/cluster-tutorial.html#id7)
  - [集群的客户端](https://www.redis.com.cn/topics/cluster-tutorial.html#id8)
  - [使用 `redis-rb-cluster` 编写一个示例应用](https://www.redis.com.cn/topics/cluster-tutorial.html#redis-rb-cluster)
  - [对集群进行重新分片](https://www.redis.com.cn/topics/cluster-tutorial.html#id10)
  - [一个更有趣的示例应用](https://www.redis.com.cn/topics/cluster-tutorial.html#id11)
  - [故障转移测试](https://www.redis.com.cn/topics/cluster-tutorial.html#id13)
  - [添加新节点到集群](https://www.redis.com.cn/topics/cluster-tutorial.html#id14)
  - [移除一个节点](https://www.redis.com.cn/topics/cluster-tutorial.html#id15)

- Redis 集群规范
  - [引言](https://www.redis.com.cn/topics/cluster-spec.html#id1)
  - [什么是 Redis 集群？](https://www.redis.com.cn/topics/cluster-spec.html#id2)
  - [Redis 集群实现的功能子集](https://www.redis.com.cn/topics/cluster-spec.html#id3)
  - [Redis 集群协议中的客户端和服务器](https://www.redis.com.cn/topics/cluster-spec.html#id4)
  - [键分布模型](https://www.redis.com.cn/topics/cluster-spec.html#id5)
  - [集群节点属性](https://www.redis.com.cn/topics/cluster-spec.html#id6)
  - [节点握手（已实现）](https://www.redis.com.cn/topics/cluster-spec.html#id7)
  - [MOVED 转向](https://www.redis.com.cn/topics/cluster-spec.html#moved)
  - [集群在线重配置（live reconfiguration）](https://www.redis.com.cn/topics/cluster-spec.html#live-reconfiguration)
  - [ASK 转向](https://www.redis.com.cn/topics/cluster-spec.html#ask)
  - [容错](https://www.redis.com.cn/topics/cluster-spec.html#id8)
  - [发布/订阅（已实现，但仍然需要改善）](https://www.redis.com.cn/topics/cluster-spec.html#id12)
  - [附录 A： CRC16 算法的 ANSI 实现参考](https://www.redis.com.cn/topics/cluster-spec.html#a-crc16-ansi)