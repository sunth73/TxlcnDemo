package com.sunth;

//import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Sunth
 * @DateTime 2019-10-10 17:55
 * 描述
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableDistributedTransaction
public class TestA_Application {
    public static void main(String[] args) {
        SpringApplication.run(TestA_Application.class,args);
    }
}
