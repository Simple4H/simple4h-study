# SimpleStudy--不断学习新的技能

#### **目录**

[复习Mybatis--v1.0](#复习mybatis--v10)

[复习Redis--v2.0](#复习redis--v20)

[验证码实现--v3.0](#验证码实现--v30)

[学习RabbitMq--v4.0](#学习rabbitmq--v40)

[Spring Boot整合RabbitMq--v4.1](#spring-boot整合rabbitmq--v41)

[任务计时器--v5.0](#任务计时器--v50) 

[并发编程与高并发--v6.0](#并发编程与高并发--v60)

------

### 复习Mybatis--[v1.0](https://github.com/simplecxm/SimpleStudy/tree/v1.0)

1. 连接池配置
2. 分页插件集成
3. Mybatis Generator自动生成Mapper

------

### 复习Redis--[v2.0](https://github.com/simplecxm/SimpleStudy/tree/v2.0)
1. ##### Redis

   - 配置Redis连接池
   - 封装Redis常用指令

2. ##### Session

   - 使用Spring Session框架。Spring Session 提供一组API和实现，用于管理用户的session信息.同时可以方便的集成Redis，对项目的侵入性很低，学起来也相对容易上手。但是灵活性却不是很好。
   - 使用自己封装的Redis、Json序列化方法。这样，在插入redis中，可以清楚的看出存入的数据信息。同时，一切都变得灵活起来。但是，这样的做法对项目的侵入性也提高了，难度也变大了。

------

### 验证码实现--[v3.0](https://github.com/simplecxm/SimpleStudy/tree/v3.0)

1. ##### 使用技术

   - spring-boot-starter-mail
   - Thymeleaf

2. ##### 具体实现

   首先注入JavaMailSender，再用SimpleMailMessage生成一个简单的邮件消息模板。

   使用Math.random生成一个四位的随机数字，并且写入Redis中，有效时间为5分钟。

   发送邮件。

   通过邮件获得验证码，并且输入验证码。这时候在Redis中取得Math.Random，并且与输入的验证码进行比较，如果相同，则代表验证通过。

------

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

   ##### ![Routing](https://github.com/simplecxm/SimpleStudy/blob/v4.0/src/main/resources/img/Routing.gif)

   - 需要明确数据字典

8. ##### 主题模式（Topics）

   ##### ![Topics](https://github.com/simplecxm/SimpleStudy/blob/v4.0/src/main/resources/img/Topics.gif)

   - 将路由键和某模式匹配
   - “#” 匹配一个或者多个
   - “*” 匹配一个

9. ##### RabbitMq的消息确认机制（事务+confirm）

   - AMQP事务机制

     ![AMQP](https://github.com/simplecxm/SimpleStudy/blob/v4.0/src/main/resources/img/Tx.gif)

     - txSelect()：将当前channel设置成transition模式。
     - txCommit()：用于提交事务。
     - txRollback()：用于回滚事务
     - 缺点：降低了吞吐量

   - Confirm模式

     - confirmSelect()
       1. 普通 waitForConfirms()，一条

          ![Comfirm-Singleton](https://github.com/simplecxm/SimpleStudy/blob/v4.0/src/main/resources/img/Comfirm-Singleton.gif)

       2. 批量 waitForComirms(),   多条。一旦有一条错误，全部返回。

          ![Comfirm-More](https://github.com/simplecxm/SimpleStudy/blob/v4.0/src/main/resources/img/Comfirm-More.gif)

       3. 异步confirm模式，提供一个回调方法

     - 最大的优点就是异步！

------

### Spring Boot整合RabbitMq--[v4.1](https://github.com/simplecxm/SimpleStudy/tree/v4.1)

![Spring-Boot-RabbitMq](https://github.com/simplecxm/SimpleStudy/blob/v4.1/src/main/resources/img/Spring-Boot-RabbitMq.gif)

### 任务计时器--[v5.0](https://github.com/simplecxm/SimpleStudy/tree/v5.0)

- 简单的定时器

- 分布式锁（Redisson）

  - 可重入锁

  - RedissonLock

    ![RedissonLock.gif](https://github.com/simplecxm/SimpleStudy/blob/v5.0/src/main/resources/img/RedissonLock.gif)

### 并发编程与高并发--[v6.0](https://github.com/simplecxm/SimpleStudy/tree/v6.0)

- ##### 线程并发编程与线程安全

  - 线程安全
    1. 原子性
       - atomic包
         1. AtomicXXX
         2. CAS原理，UnSafe
         3. AtomicLong与LongAddr
         4. AtomicReference与AtomicReferenceFiledUpdater
         5. AtomicStampReference
       - 锁
         1. synchronized--修饰代码块、方法、静态方法、类
         2. Lock
    2. 可见性
       - synchronized
       - volatile
         1. volatile读
         2. volatile写
         3. volatile使用
    3. 有序性
       - happen-before原则
  - 安全发布对象
    1. 发布对象与对象溢出
    2. 安全发布的四个方法
  - 线程不安全类
    1. StringBulider->StringBuffer
    2. SimpleDateFormat->JodaTime
    3. ArrayList、HashMap、HashSet
    4. 不安全类的使用
  - 不可变对象
    1. 不可变对象条件
    2. final关键字--修饰类、方法、变量
    3. Connections.unmodifiableXXX
    4. Guava ImmutableXXX
  - 线程封闭
    1. Ad-hoc线程封闭
    2. 堆栈封闭
    3. ThreadLocal--JDBC分析
  - Java同步容器
    1. ArrayList-->Vector、Stack
    2. HashMap-->HashTable
    3. Collections.synchronizedXXX
  - Java并发容器
    1. ArrayList-->CopyOnWriteArrayList
    2. HashSet、TreeSet-->CopyOnWriteArraySet、ConcurrentSkipListSet
    3. HashMap、TreeMap-->ConcurrentHashMap、ConcurrentSkipListMap
  - 安全共享对象策略
    1. 线程限制
    2. 共享只读
    3. 线程安全对象
    4. 被守护对象
  - AQS
    1. 设计
    2. 组件
       - CountDownLatch
       - Semaphore
       - CyclicBarrier
       - ReentrantLock
         1. ReentrantLock与Synchronized
         2. ReentrantLock相关的Lock
         3. Condition
  - J.U.C
    - 构成介绍 
      1. Atomic
      2. locks
      3. collections
      4. tools（AQS）
      5. executor
    - 组件补充
      1. FutureTask
         - Callable与Runnable
         - Future接口
         - FutureTask接口
      2. Fork/Join框架
      3. BlockingQueue
  - 线程池
    1. new Thread弊端
    2. 线程池的好处
    3. ThreadPoolExecutor
       - 参数
       - 状态
       - 方法
    4. Executor框架接口
       - newCacheThreadPool
       - newFixedThreadPool
       - newScheduleThreadPool
       - newSingleThreadPool
  - 死锁
    1. 产生的必要条件
    2. 预防
  - spring的线程安全
    1. spring单实例的线程安全问题
    2. 有状态bean与无状态bean
    3. spring bean的线程安全方案
  - HashMap与ConnectionHashMap深入分析

- ##### 高并发解决方案

  - 扩容
    1. 垂直扩容
    2. 水平扩容
  - 缓存
    1. 特征
       - 命中率-->影响因素
       - 最大元素（空间）
       - 清空策略
    2. 分类与应用场景
       - 本地缓存-->GuavaCache
       - 分布式缓存
         1. Redis
         2. memcache
    3. 高并发场景下缓存常见问题
       - 缓存一致性
       - 缓存并发问题
       - 缓存穿透问题
       - 缓存雪崩
  - 消息队列
    1. 消息队列特征
       - 业务无关
       - FIFO
       - 容灾
       - 性能
    2. 队列使用原因
    3. 消息队列好处
       - 业务解耦
       - 最终一致性
       - 广播
       - 错峰与流控
    4. 消息队列举例
       - kafka
       - rabbitMq
  - 应用拆分
    1. 原则
       - 业务优先
       - 循序渐进
       - 兼顾技术
         1. 重构
         2. 分层
       - 可靠测试
    2. 思考
       - 应用之间通信
         1. 服务化Dubbo
         2. 微服务SpringCloud
         3. 消息队列
       - 应用之间的数据库设计
       - 避免事务操作跨业务
  - 限流
    1. 常用限流算法
       - 计数器法
       - 滑动窗口
       - 漏桶算法
       - 令牌桶算法
    2. Guava RateLimter限流的使用
    3. 分布式限流实现
  - 服务降级与服务熔断
    1. 服务降级
       - 自动降级
       - 人工降级
    2. 服务熔断
       - 熔断设计
    3. Hystrix
  - 数据库切库、分库、分表
    1. 切库--自定义注解切库实现
    2. 分库与支持多数据源--支持多数据源实现
    3. 分表--shardbatis2.0
  - 高可用手段
    1. 分布式任务系统--elastic-job+zookeeper
    2. 主备--apachecurator + zookeeper分布式锁
    3. 监控报警机制
科目一 YES