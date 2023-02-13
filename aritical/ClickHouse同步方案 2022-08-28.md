## 1. ClickHouse集群模式

### 集群模式与单机模式的区别：

​	暂时不考虑副本概念

​	建表差别（需要了解集群环境）

​			**分布式表** distributed引擎 

​			**本地表 replacingMergeTree引擎（分别写本地表），代理或者负载均衡**

​	写入差别（依赖建表语句，同步参数中的指定同步字段）

​			

## 2. ClickHouse同步参数

![image-20220824095239603](http://mk-pig.oss-cn-hangzhou.aliyuncs.com/img/image-20220824095239603.png)



## 3. 工程化

采集侧一致性

同步侧一致性