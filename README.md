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

   

