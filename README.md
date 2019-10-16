### TxlcnDemo
- 本demo基于txlcn 5.0.2, consul 1.6.1, springboot 2.1.5 ,cloud Greenwich.SR1 ,jdk 1.8
> 操作步骤
1. 下载TM https://github.com/codingapi/tx-lcn/releases, 解压导入Eclipse/idea
2. 下载注册中心consul https://www.consul.io/, (使用eureka则跳过) 
3. 搭建springboot项目，并创建serverA,serverB两个module。(一个服务端，一个客户端)
4. 父pom文件加入
    ```maven
    <dependency>
            <groupId>com.codingapi.txlcn</groupId>
            <artifactId>txlcn-tc</artifactId>
            <version>5.0.2.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>com.codingapi.txlcn</groupId>
            <artifactId>txlcn-txmsg-netty</artifactId>
            <version>5.0.2.RELEASE</version>
        </dependency>
    ```
