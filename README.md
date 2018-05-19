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