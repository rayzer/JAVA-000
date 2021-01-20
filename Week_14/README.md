### 第十四周作业（周三）（第26课）

1. (选做) 自己安装和操作 RabbitMQ，RocketMQ，Pulsar，以及 Camel 和 Spring Integration。
2. (必做) 思考和设计自定义 MQ 第二个版本或第三个版本，写代码实现其中至少一个功能点，把设计思路和实现代码，提交到github。

    第二个版本: 自定义Queue
   去掉内存Queue，设计自定义Queue，实现消息确认和消费offset
    1) 自定义内存Message数组模拟Queue。
    2) 使用指针记录当前消息写入位置。
    3) 对于每个命名消费者，用指针记录消费位置。
    
   第三个版本: 基于SpringMVC实现MQServer
   拆分broker和client(包括producer和consumer)
    1) 将Queue保存到web server端
       
   [kmq-server](kmq-server)

    2) 设计消息读写API接口，确认接口，提交 offset 接口
    3) producer 和 consumer通过 httpclient 访问 Queue
    4) 实现消息确认，offset提交
    5) 实现consumer从offset增量拉取

3. (挑战☆☆☆☆☆) 完成所有其他版本的要求。期限一年。