### 第十二周作业（周三）（第23课）

1. (必做) 配置redis的主从复制，sentinel高可用，Cluster集群。 提交如下内容到github:
    1) config配置文件
    2) 启动和操作、验证集群下数据读写的命令步骤。

[主从复制](redis-replica)
```
Ξ JAVA-000/Week_12 git:(main) ▶ cd redis-replica 
Ξ Week_12/redis-replica git:(main) ▶ docker-compose up -d
Creating network "redis-replica_default" with the default driver
Creating redis-2 ... done
Creating redis-1 ... done
Ξ Week_12/redis-replica git:(main) ▶ redis-cli set ray 001
OK
Ξ Week_12/redis-replica git:(main) ▶ redis-cli -p 6380 get ray    
"001"
```
[Sentinel高可用](redis-sentinel)
```
Ξ Week_12/redis-sentinel git:(main) ▶ docker-compose up -d
Creating network "redis-sentinel_default" with the default driver
Creating redis-2  ... done
Creating sentinel ... done
Creating redis-1  ... done
Ξ Week_12/redis-sentinel git:(main) ▶ docker ps
CONTAINER ID   IMAGE                COMMAND                  CREATED          STATUS          PORTS                                NAMES
815c8bc83def   redis:6.0.9-alpine   "docker-entrypoint.s…"   29 seconds ago   Up 27 seconds   6379/tcp, 0.0.0.0:26379->26379/tcp   sentinel
7115cf779e41   redis:6.0.9-alpine   "docker-entrypoint.s…"   29 seconds ago   Up 27 seconds   0.0.0.0:6379->6379/tcp               redis-1
484b168135bb   redis:6.0.9-alpine   "docker-entrypoint.s…"   29 seconds ago   Up 27 seconds   0.0.0.0:6380->6379/tcp               redis-2
Ξ Week_12/redis-sentinel git:(main) ▶ docker logs sentinel
1:X 04 Jan 2021 06:17:40.140 # oO0OoO0OoO0Oo Redis is starting oO0OoO0OoO0Oo
1:X 04 Jan 2021 06:17:40.140 # Redis version=6.0.9, bits=64, commit=00000000, modified=0, pid=1, just started
1:X 04 Jan 2021 06:17:40.140 # Configuration loaded
1:X 04 Jan 2021 06:17:40.144 * Running mode=sentinel, port=26379.
1:X 04 Jan 2021 06:17:40.144 # WARNING: The TCP backlog setting of 511 cannot be enforced because /proc/sys/net/core/somaxconn is set to the lower value of 128.
1:X 04 Jan 2021 06:17:40.150 # Could not rename tmp config file (Resource busy)
1:X 04 Jan 2021 06:17:40.150 # WARNING: Sentinel was not able to save the new configuration on disk!!!: Invalid argument
1:X 04 Jan 2021 06:17:40.150 # Sentinel ID is 49a543485e21537e2ba39485b491e58eeb2b4567
1:X 04 Jan 2021 06:17:40.150 # +monitor master redis-1 172.26.0.4 6379 quorum 1
1:X 04 Jan 2021 06:17:51.239 * +slave slave 172.26.0.2:6379 172.26.0.2 6379 @ redis-1 172.26.0.4 6379
1:X 04 Jan 2021 06:17:51.250 # Could not rename tmp config file (Resource busy)
1:X 04 Jan 2021 06:17:51.251 # WARNING: Sentinel was not able to save the new configuration on disk!!!: Invalid argument
Ξ Week_12/redis-sentinel git:(main) ▶ redis-cli -p 6379 info | grep role
role:master
Ξ Week_12/redis-sentinel git:(main) ▶ redis-cli -p 6380 info | grep role
role:slave
Ξ Week_12/redis-sentinel git:(main) ▶ docker stop redis-1
redis-1
Ξ Week_12/redis-sentinel git:(main) ▶ docker logs -f sentinel
...
1:X 04 Jan 2021 06:22:19.963 # +sdown master redis-1 172.26.0.4 6379
1:X 04 Jan 2021 06:22:19.963 # +odown master redis-1 172.26.0.4 6379 #quorum 1/1
1:X 04 Jan 2021 06:22:19.963 # +new-epoch 1
1:X 04 Jan 2021 06:22:19.964 # +try-failover master redis-1 172.26.0.4 6379
1:X 04 Jan 2021 06:22:19.973 # Could not rename tmp config file (Resource busy)
1:X 04 Jan 2021 06:22:19.974 # WARNING: Sentinel was not able to save the new configuration on disk!!!: Invalid argument
1:X 04 Jan 2021 06:22:19.974 # +vote-for-leader 49a543485e21537e2ba39485b491e58eeb2b4567 1
1:X 04 Jan 2021 06:22:19.975 # +elected-leader master redis-1 172.26.0.4 6379
1:X 04 Jan 2021 06:22:19.975 # +failover-state-select-slave master redis-1 172.26.0.4 6379
1:X 04 Jan 2021 06:22:20.030 # +selected-slave slave 172.26.0.2:6379 172.26.0.2 6379 @ redis-1 172.26.0.4 6379
1:X 04 Jan 2021 06:22:20.031 * +failover-state-send-slaveof-noone slave 172.26.0.2:6379 172.26.0.2 6379 @ redis-1 172.26.0.4 6379
1:X 04 Jan 2021 06:22:20.133 * +failover-state-wait-promotion slave 172.26.0.2:6379 172.26.0.2 6379 @ redis-1 172.26.0.4 6379
1:X 04 Jan 2021 06:22:20.211 # Could not rename tmp config file (Resource busy)
1:X 04 Jan 2021 06:22:20.211 # WARNING: Sentinel was not able to save the new configuration on disk!!!: Invalid argument
1:X 04 Jan 2021 06:22:20.211 # +promoted-slave slave 172.26.0.2:6379 172.26.0.2 6379 @ redis-1 172.26.0.4 6379
1:X 04 Jan 2021 06:22:20.211 # +failover-state-reconf-slaves master redis-1 172.26.0.4 6379
1:X 04 Jan 2021 06:22:20.280 # +failover-end master redis-1 172.26.0.4 6379
1:X 04 Jan 2021 06:22:20.280 # +switch-master redis-1 172.26.0.4 6379 172.26.0.2 6379
1:X 04 Jan 2021 06:22:20.282 * +slave slave 172.26.0.4:6379 172.26.0.4 6379 @ redis-1 172.26.0.2 6379
1:X 04 Jan 2021 06:22:20.288 # Could not rename tmp config file (Resource busy)
1:X 04 Jan 2021 06:22:20.288 # WARNING: Sentinel was not able to save the new configuration on disk!!!: Invalid argument
Ξ Week_12/redis-sentinel git:(main) ▶ redis-cli -p 6380 info | grep role
role:master
Ξ Week_12/redis-sentinel git:(main) ▶ redis-cli -p 6380 set ray 001
OK
Ξ Week_12/redis-sentinel git:(main) ▶ redis-cli -p 6380 get ray
"001"
```
[Cluster集群](redis-cluster)
```
Ξ Week_12/redis-cluster git:(main) ▶ ip=$(ipconfig getifaddr en0) docker-compose up -d
Creating network "redis-cluster_default" with the default driver
Creating redis-6 ... done
Creating redis-5 ... done
Creating redis-4 ... done
Creating redis-3 ... done
Creating redis-2 ... done
Creating redis-1 ... done
Creating redis-cluster-creator ... done

Ξ Week_12/redis-cluster git:(main) ▶ docker logs redis-cluster-creator
>>> Performing hash slots allocation on 6 nodes...
Master[0] -> Slots 0 - 5460
Master[1] -> Slots 5461 - 10922
Master[2] -> Slots 10923 - 16383
Adding replica 10.243.229.178:7004 to 10.243.229.178:7000
Adding replica 10.243.229.178:7005 to 10.243.229.178:7001
Adding replica 10.243.229.178:7003 to 10.243.229.178:7002
>>> Trying to optimize slaves allocation for anti-affinity
[WARNING] Some slaves are in the same host as their master
M: 87ad2cd64f959ec7e4b0a60edd9271ff1ef4d277 10.243.229.178:7000
   slots:[0-5460] (5461 slots) master
M: 1855967c9c89e3754f56f7ea59ff5d0acf6aa53c 10.243.229.178:7001
   slots:[5461-10922] (5462 slots) master
M: 73696bc2696d495622466e3b11e82b4efb7e45fe 10.243.229.178:7002
   slots:[10923-16383] (5461 slots) master
S: 2c246f4066947a74c2b5ef31a8de8e8a24f6d43c 10.243.229.178:7003
   replicates 87ad2cd64f959ec7e4b0a60edd9271ff1ef4d277
S: c57cc7a5fd83c886b95a695e06736b8b47e42104 10.243.229.178:7004
   replicates 1855967c9c89e3754f56f7ea59ff5d0acf6aa53c
S: c89df695a319d4bc3f5b7ecb4eeba199c2e99e9e 10.243.229.178:7005
   replicates 73696bc2696d495622466e3b11e82b4efb7e45fe
Can I set the above configuration? (type 'yes' to accept): >>> Nodes configuration updated
>>> Assign a different config epoch to each node
>>> Sending CLUSTER MEET messages to join the cluster
Waiting for the cluster to join
.
>>> Performing Cluster Check (using node 10.243.229.178:7000)
M: 87ad2cd64f959ec7e4b0a60edd9271ff1ef4d277 10.243.229.178:7000
   slots:[0-5460] (5461 slots) master
   1 additional replica(s)
S: c89df695a319d4bc3f5b7ecb4eeba199c2e99e9e 10.243.229.178:7005
   slots: (0 slots) slave
   replicates 73696bc2696d495622466e3b11e82b4efb7e45fe
S: 2c246f4066947a74c2b5ef31a8de8e8a24f6d43c 10.243.229.178:7003
   slots: (0 slots) slave
   replicates 87ad2cd64f959ec7e4b0a60edd9271ff1ef4d277
M: 73696bc2696d495622466e3b11e82b4efb7e45fe 10.243.229.178:7002
   slots:[10923-16383] (5461 slots) master
   1 additional replica(s)
S: c57cc7a5fd83c886b95a695e06736b8b47e42104 10.243.229.178:7004
   slots: (0 slots) slave
   replicates 1855967c9c89e3754f56f7ea59ff5d0acf6aa53c
M: 1855967c9c89e3754f56f7ea59ff5d0acf6aa53c 10.243.229.178:7001
   slots:[5461-10922] (5462 slots) master
   1 additional replica(s)
[OK] All nodes agree about slots configuration.
>>> Check for open slots...
>>> Check slots coverage...
[OK] All 16384 slots covered.

Ξ Week_12/redis-cluster git:(main) ▶ redis-cli -p 7000 cluster nodes
c89df695a319d4bc3f5b7ecb4eeba199c2e99e9e 10.243.229.178:7005@17005 slave 73696bc2696d495622466e3b11e82b4efb7e45fe 0 1609745782990 3 connected
2c246f4066947a74c2b5ef31a8de8e8a24f6d43c 10.243.229.178:7003@17003 slave 87ad2cd64f959ec7e4b0a60edd9271ff1ef4d277 0 1609745783000 1 connected
73696bc2696d495622466e3b11e82b4efb7e45fe 10.243.229.178:7002@17002 master - 0 1609745782000 3 connected 10923-16383
87ad2cd64f959ec7e4b0a60edd9271ff1ef4d277 10.243.229.178:7000@17000 myself,master - 0 1609745781000 1 connected 0-5460
c57cc7a5fd83c886b95a695e06736b8b47e42104 10.243.229.178:7004@17004 slave 1855967c9c89e3754f56f7ea59ff5d0acf6aa53c 0 1609745784016 2 connected
1855967c9c89e3754f56f7ea59ff5d0acf6aa53c 10.243.229.178:7001@17001 master - 0 1609745782000 2 connected 5461-10922

Ξ Week_12/redis-cluster git:(main) ▶ redis-cli -c -p 7000 set ray 0001
OK
Ξ Week_12/redis-cluster git:(main) ▶ redis-cli -c -p 7004 get ray
"0001"
```

2. (选做) 练习示例代码里下列类中的作业题: 08cache/redis/src/main/java/io/kimmking/cache/RedisApplication.java
3. (挑战☆) 练习redission的各种功能;
4. (挑战☆☆) 练习hazelcast的各种功能;
5. (挑战☆☆☆) 搭建hazelcast 3节点集群，写入100万数据到一个map，模拟和演示高可用，测试一下性能;

### 第十二周作业（周三）（第24课）

1. (必做) 搭建ActiveMQ服务，基于JMS，写代码分别实现对于queue和topic的消息生产和消费，代码提交到github。
   
[work24_01](work24_01)

2. (选做) 基于数据库的订单表，模拟消息队列处理订单:
   1) 一个程序往表里写新订单，标记状态为未处理(status=0);
   2) 另一个程序每隔100ms定时从表里读取所有status=0的订单，打印一下订单数据，然后改成完成status=1;
   3) (挑战☆) 考虑失败重试策略，考虑多个消费程序如何协作。 
3. (选做) 将上述订单处理场景，改成使用ActiveMQ发送消息处理模式。
4. (挑战☆☆) 搭建ActiveMQ的network集群和master-slave主从结构。
5. (挑战☆☆☆) 基于ActiveMQ的MQTT实现简单的聊天功能或者Android消息推送。
6. (挑战☆) 创建一个RabbitMQ，用Java代码实现简单的AMQP协议操作。
7. (挑战☆☆) 搭建RabbitMQ集群，重新实现前面的订单处理。
8. (挑战☆☆☆) 使用Apache Camel打通上述ActiveMQ集群和RabbitMQ集群，实现所有写入到ActiveMQ上的一个队列q24的消息，自动转发到RabbitMQ。
9. (挑战☆☆☆) 压测ActiveMQ和RabbitMQ的性能。