package com.sunth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Sunth
 * @DateTime 2019-10-11 9:58
 * 描述
 */
@RestController
@RequestMapping("/test")
public class ControllerB {
    @Autowired
    ServiceB serviceB;

    @RequestMapping("/add")
    public String Update(@RequestParam("money") int money) {
        Optional.of("======"+money).ifPresent(System.out::println);
        return serviceB.update(money, "zhangsan");
    }
}
