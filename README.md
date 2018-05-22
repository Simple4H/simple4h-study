# SimpleStudy

## 不断学习新的技能！

### 复习Mybatis--[v1.0](https://github.com/simplecxm/SimpleStudy/tree/v1.0)

1. 连接池配置
2. 分页插件集成
3. Mybatis Generator自动生成Mapper

### 复习Redis--[v2.0](https://github.com/simplecxm/SimpleStudy/tree/v2.0)
1. ##### Redis

   - 配置Redis连接池
   - 封装Redis常用指令

2. ##### Session

   - 使用Spring Session框架。Spring Session 提供一组API和实现，用于管理用户的session信息.同时可以方便的集成Redis，对项目的侵入性很低，学起来也相对容易上手。但是灵活性却不是很好。
   - 使用自己封装的Redis、Json序列化方法。这样，在插入redis中，可以清楚的看出存入的数据信息。同时，一切都变得灵活起来。但是，这样的做法对项目的侵入性也提高了，难度也变大了。

### 验证码实现--[v3.0](https://github.com/simplecxm/SimpleStudy/tree/v3.0)

1. ##### 使用技术

   - spring-boot-starter-mail
   - Thymeleaf

2. ##### 具体实现

   首先注入JavaMailSender，再用SimpleMailMessage生成一个简单的邮件消息模板。

   使用Math.random生成一个四位的随机数字，并且写入Redis中，有效时间为5分钟。

   发送邮件。

   通过邮件获得验证码，并且输入验证码。这时候在Redis中取得Math.Random，并且与输入的验证码进行比较，如果相同，则代表验证通过。

### 学习RabbitMq--[v4.0](https://github.com/simplecxm/SimpleStudy/tree/v4.0)

1. ##### RabbitMq的简单连接

2. ##### 简单队列

   ##### ![SimpleQueue](https://github.com/simplecxm/SimpleStudy/blob/v4.0/src/main/resources/img/SimpleQueue.gif)

   - ##### 优点

     1. 简单

   - ##### 不足

     1. 耦合性高，生产者一一对应消费者。（如果需要多个消费者队列，这时候就不行了）
     2. 队列名字一旦改变，这时候就要同时变更。

3. ##### 工作队列

   - ##### 优点

     1. 一个生产者可以有多个消费者（一对多）。在实际开发中，生产者发送消息是相对简单的，而消费者是跟业务相结合的。消费者接受到消息以后，需要进行一些业务的处理，需要花费多一点的时间。这时候，消息队列就会积压很多消息，这时候，多个消费者的作用就体现出来了。

   - ##### 方式

     1. ##### 轮训分发（Round-Robin）

        ##### ![Round-Robin](https://github.com/simplecxm/SimpleStudy/blob/v4.0/src/main/resources/img/Round-Robin.gif)

        - 多个消费者消费的消息是一样的。
        - 缺点是不会考虑业务逻辑的复杂。任务消息总是均分的。

     2. ##### 公平分发（Fair-Dispatch）

        ##### ![Fair-Dispatch](https://github.com/simplecxm/SimpleStudy/blob/v4.0/src/main/resources/img/Fair-Dispatch.gif)

        - 有效的解决轮训分发的缺点

4. ##### 消息应答与消息持久化

   - ###### autoAck

     - autoAck=true，（自动确认模式）一旦RabbitMq将消息发给消费者，就会从内存中删除。这种情况下，消费者被突然结束，就会失去正在处理的消息。
     - autoAck=false，（手动确认模式）如果有个消费者突然结束，就会发送给其他可以运行的消费者。（因为手动模式消费完消息，需要手动返回一个Ack）。这保证了数据的安全。

   - ###### 消息持久化

     - durable=true，开启消息持久化。如果队列已经定义，那么true则会报错（RabbitMq不允许修改已经存在的队列）。

5. ##### 订阅模式(Publish-Subscribe)

   ##### ![Publish-Subscribe](https://github.com/simplecxm/SimpleStudy/blob/v4.0/src/main/resources/img/Publish-Subscribe.gif)

   - 一个生产者有多个消费者。
   - 每个消费者有一个队列。
   - 生产者没有将消息直接发送给消费者，而是发送到转发器（Exchange）。
   - 每个队列都要绑定到转发器上。
   - 生产者的消息经过交换机，到达队列，就能实现**一个消息被多个消费者消费**。
   - 转发器没有存储消息的能力，所以需要队列绑定。

6. ##### 转换器（Exchange）

   - 一方面是接收生产者的消息，另一方面是向队列推送消息。
   - 匿名转发
   - 交换机类型
     1. Direct Exchange （处理路由键）
     2. Fanout Exchange（不处理路由键）
     3. Topic Exchange 
     4. Headers exchange

7. ##### 路由模式（Routing）

   ##### ![Routing](https://github.com/simplecxm/SimpleStudy/blob/v4.0/src/main/resources/img/Routing.gi)

   - 需要明确数据字典
