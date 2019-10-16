package com.sunth;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Sunth
 * @DateTime 2019-10-11 10:10
 * 描述
 */
@FeignClient(value = "txlcna")
@RequestMapping("/testa")
public interface FeignClientB {
    @RequestMapping("/update")
    public int Update(@RequestParam("money") int money);
}
