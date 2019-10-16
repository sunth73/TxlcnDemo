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
@RequestMapping("/testa")
public class ControllerA {
    @Autowired
    ServiceA serviceA;
    @RequestMapping("/update")
    public int Update(@RequestParam("money") int money) {
        Optional.of("++++++++++++++"+money).ifPresent(System.out::println);
        return serviceA.update(money, "zhangsan");
    }
}
