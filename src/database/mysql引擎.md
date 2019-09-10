## InnoDB
1、支持事物
2、适合OLTP
3、行锁
4、支持外键
5、非锁定读
6、MVCC，以此提高并发

## MyISAM
1、不支持事物
2、表锁
3、缓存索引

## Maria
1、升级版MyISAM
2、支持索引文件
3、行锁
4、缓存数据

## NDB
1、集群存储引擎
2、数据存在内存
3、复杂连接操作很慢，因为是在Mysql数据库层完成

## Memory
1、数据存在内存
2、Hash索引
3、表锁

## Archive

## Federated


