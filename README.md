# Simple4H-Study

Simple4H-Study是为了尝鲜一些技术，当然了，这些技术也是简单的使用，很多都是点到为止，并没有深入去实践。所有的服务都是单机，没有涉及到集群。同时，在Sample模块→[*Demo*](https://github.com/simplecxm/simple4h-study/blob/master/sample/src/main/java/com/simple4h/sample/demo/Demo1.java) 中，有一些个人在平时开发中，觉得还挺好用的代码技巧。旧的→[README.md](https://github.com/simplecxm/simple4h-study/blob/master/README_old.md)

## 快速启动

项目启动需要依赖一些服务，如果你本机有安装上述的服务，那直接启动项目就好了。

1. 安装Docker
2. 进入项目，在项目的根路径找到`docker-compose.yml`
3. 执行下面的命令

```docker
docker-compose -f Docker-compose-backup.yml -p simple4h-project up
```

## 已实现

- Spring Boot
- Spring Cloud
- Mybatis
- Redis
- Consul
- Feign
- RabbitMQ
- Kafka
- Gateway
    - RateLimit
- Zipkin
- Sleuth
- DockerFile & Docker-Compose
## 感谢
<img src="https://raw.githubusercontent.com/simplecxm/simple4h-study/master/file/jetbrains-variant-4.png" width="50%" alt="Jetbrains">