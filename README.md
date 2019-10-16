### TxlcnDemo
- 本demo基于txlcn 5.0.2, consul 1.6.1, springboot 2.1.5 ,cloud Greenwich.SR1 ,jdk 1.8
> 操作步骤
1. 下载TM https://github.com/codingapi/tx-lcn/releases, 解压导入Eclipse/idea
2. 下载注册中心consul https://www.consul.io/, (使用eureka则跳过) 
3. 搭建springboot项目，并创建serverA,serverB两个module。(一个服务端，一个客户端)
4. 父pom文件加入
    ```maven
        <!-- txlcn相关 -->
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
            <!-- consul注册中心相关 -->
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-starter-consul-discovery</artifactId>
            </dependency>
        ```
5. 启动类加注解  @EnableDistributedTransaction
     ```java
            @SpringBootApplication
            @EnableDiscoveryClient
            @EnableDistributedTransaction
            public class TestA_Application {
                public static void main(String[] args) {
                    SpringApplication.run(TestA_Application.class,args);
                }
            }
        ```
6. application.propertis
        ```properties
            spring.application.name=txlcna
            server.port=8900
            spring.datasource.driver-class-name=com.mysql.jdbc.Driver
            spring.datasource.url=jdbc:mysql://127.0.0.1:3306/txlcna?allowMultiQueries=true&useUnicode=true&characterEncoding=UTF-          8&serverTimezone=UTC
            spring.datasource.username=root
            spring.datasource.password=123456
            #sql打印
            logging.level.com.sunth.MapperA=debug
            #配置注册中心，不配置也可，只要导入consul包
            #spring.cloud.consul.host=localhost
            #spring.cloud.consul.port=8500
            ##注册到consul的服务名称
            #spring.cloud.consul.discovery.serviceName=txlcna

            #eureka.client.service-url.defaultZone=http://127.0.0.1:8761/eureka/
            #eureka.instance.instance-id=txlcna_8900
            #eureka.instance.prefer-ip-address=true
        ```
7. 业务层方法加入注解 (@TxTransaction,@LcnTransaction)根据自己需要选择开启哪一类
    ```java
        @TxTransaction
        public String  update(int money, String username) {
            String result="";

                int b=-1;
                int a=feignClientB.Update(money);
                if(a>0){
                    b=mapperB.update(money,"zhangsan");
                }
                int m=mapperB.select("zhangsan");
                if(m<=0){
                    result="error";
                    throw new RuntimeException();
                }else{
                    result= "success";
                }
            return result;

        }
    ```
8. 启动下载并导入的TM(或者TM打包后启动该jar包),启动consul(consul agent -dev
pause)，启动服务端，客户端(feign)
9. 测试
