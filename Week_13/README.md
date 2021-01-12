### 第十三周作业（周六）（第25课）

1. (必做) 搭建一个3节点Kafka集群，测试功能和性能; 实现 spring kafka 下对 kafka 集群的操作，将代码提交到 github。
   
[Work25_01](Work25_01)

```
Ξ cloud/kafka-cluster → docker-compose up -d
Creating network "kafka-cluster_default" with the default driver
Creating kafka-cluster_zookeeper_1 ... done
Creating kafka-cluster_kafka1_1    ... done
Creating kafka-cluster_kafka3_1    ... done
Creating kafka-cluster_kafka2_1    ... done

Ξ cloud/kafka-cluster → docker ps
CONTAINER ID   IMAGE                           COMMAND                  CREATED          STATUS          PORTS                                                                                                    NAMES
a1d3ecb4a186   wurstmeister/kafka:2.13-2.7.0   "start-kafka.sh"         30 seconds ago   Up 29 seconds   0.0.0.0:9093->9093/tcp                                                                                   kafka-cluster_kafka3_1
7a58ef94ee10   wurstmeister/kafka:2.13-2.7.0   "start-kafka.sh"         30 seconds ago   Up 29 seconds   0.0.0.0:9092->9092/tcp                                                                                   kafka-cluster_kafka2_1
ad661790a9d4   wurstmeister/kafka:2.13-2.7.0   "start-kafka.sh"         30 seconds ago   Up 29 seconds   0.0.0.0:9091->9091/tcp                                                                                   kafka-cluster_kafka1_1
a4e1f3482b3c   wurstmeister/zookeeper:3.4.6    "/bin/sh -c '/usr/sb…"   31 seconds ago   Up 30 seconds   0.0.0.0:2181->2181/tcp, 0.0.0.0:2888->2888/tcp, 22/tcp, 0.0.0.0:3888->3888/tcp, 0.0.0.0:8088->8080/tcp   kafka-cluster_zookeeper_1

Ξ cloud/kafka-cluster → docker exec -it kafka-cluster_kafka1_1 /bin/sh
/opt/kafka_2.13-2.7.0 # bin/kafka-topics.sh --zookeeper zookeeper:2181 --create --topic testk --partitions 4 --replication-factor 1
Created topic testk.
/opt/kafka_2.13-2.7.0 # bin/kafka-topics.sh --zookeeper zookeeper:2181 --list
testk
/opt/kafka_2.13-2.7.0 # bin/kafka-topics.sh --zookeeper zookeeper:2181 --describe --topic testk
Topic: testk	PartitionCount: 4	ReplicationFactor: 1	Configs:
	Topic: testk	Partition: 0	Leader: 1	Replicas: 1	Isr: 1
	Topic: testk	Partition: 1	Leader: 2	Replicas: 2	Isr: 2
	Topic: testk	Partition: 2	Leader: 3	Replicas: 3	Isr: 3
	Topic: testk	Partition: 3	Leader: 1	Replicas: 1	Isr: 1
/opt/kafka_2.13-2.7.0 # bin/kafka-console-consumer.sh --bootstrap-server localhost:9091 --from-beginning --topic testk

Ξ ~ → docker exec -it kafka-cluster_kafka2_1 /bin/sh
/opt/kafka_2.13-2.7.0 # bin/kafka-console-producer.sh --bootstrap-server localhost:9092 --topic testk

/opt/kafka_2.13-2.7.0 # bin/kafka-producer-perf-test.sh --topic testk --num-records 400000 --record-size 1000 --throughput 20000 --producer-props bootstrap.servers=localhost:9091
45383 records sent, 9076.6 records/sec (8.66 MB/sec), 715.8 ms avg latency, 1262.0 ms max latency.
77242 records sent, 15448.4 records/sec (14.73 MB/sec), 1689.8 ms avg latency, 2352.0 ms max latency.
70784 records sent, 14156.8 records/sec (13.50 MB/sec), 2335.9 ms avg latency, 2813.0 ms max latency.
71228 records sent, 14245.6 records/sec (13.59 MB/sec), 2269.7 ms avg latency, 3032.0 ms max latency.
105004 records sent, 21000.8 records/sec (20.03 MB/sec), 1539.3 ms avg latency, 2720.0 ms max latency.
400000 records sent, 15126.876678 records/sec (14.43 MB/sec), 1743.79 ms avg latency, 3032.00 ms max latency, 1853 ms 50th, 2675 ms 95th, 2953 ms 99th, 3006 ms 99.9th.

/opt/kafka_2.13-2.7.0 # bin/kafka-consumer-perf-test.sh --bootstrap-server localhost:9091 --topic testk --fetch-size 1048576 --messages 1000000
start.time, end.time, data.consumed.in.MB, MB.sec, data.consumed.in.nMsg, nMsg.sec, rebalance.time.ms, fetch.time.ms, fetch.MB.sec, fetch.nMsg.sec
2021-01-12 14:00:09:119, 2021-01-12 14:00:19:335, 953.6934, 93.3529, 1000025, 97888.1167, 1610460010859, -1610460000643, -0.0000, -0.0006
```

2. (选做) 安装kafka-manager工具，监控kafka集群状态。 
3. (挑战☆) 演练本课提及的各种生产者和消费者特性。
4. (挑战☆☆☆) Kafka金融领域实战: 
   在证券或者外汇、数字货币类金融核心交易系统里，对于订单的处理，大概可以分为收单、定序、撮合、清算等步骤。其中我们一般可以用mq来实现订单定序，然后将订单发送给撮合模块。
    1) 收单: 请实现一个订单的REST接口，能够接收一个订单Order对象;
    2) 定序: 将Order对象写入到kafka集群的order.usd2cny队列，要求数据有序并且不丢失;
    3) 撮合: 模拟撮合程序(不需要实现撮合逻辑)，从kafka获取order数据，并打印订单信息， 要求可重放, 顺序消费, 消息仅处理一次。