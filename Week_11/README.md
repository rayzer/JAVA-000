### 第十二周作业（周六）（第22课）

1. (选做) 命令行下练习操作Redis的各种基本数据结构和命令。
2. (选做) 分别基于jedis，RedisTemplate，Lettuce，Redission实现redis基本操作的demo，可以使用spring-boot集成上述工具。
3. (选做) spring集成练习
    1) 实现update方法，配合@CachePut
    2) 实现delete方法，配合@CacheEvict
    3) 将示例中的spring集成Lettuce改成jedis或redisson。
4. (必做) 基于Redis封装分布式数据操作: 
    1) 在Java中实现一个简单的分布式锁; 
    2) 在Java中实现一个分布式计数器，模拟减库存。
   
[Work22_04](work22_04)

5. 基于Redis的PubSub实现订单异步处理
6. (挑战☆) 基于其他各类场景，设计并在示例代码中实现简单demo: 
    1) 实现分数排名或者排行榜;
    2) 实现全局ID生成;l
    3) 基于Bitmap实现id去重;
    4) 基于HLL实现点击量计数。 
    5) 以redis作为数据库，模拟使用lua脚本实现前面课程的外汇交易事务。
7. (挑战☆☆) 升级改造项目:
    1) 实现guava cache的spring cache适配; 
    2) 替换jackson序列化为fastjson或者fst，kryo; 
    3) 对项目进行分析和性能调优。 
8. (挑战☆☆☆) 以redis作为基础实现上个模块的自定义rpc的注册中心。