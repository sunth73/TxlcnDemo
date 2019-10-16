package com.sunth;

//import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author Sunth
 * @DateTime 2019-10-11 9:48
 * 描述
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.sunth")
@EnableDistributedTransaction
public class TestB_Application {
    public static void main(String[] args) {
        SpringApplication.run(TestB_Application.class,args);
    }
}
