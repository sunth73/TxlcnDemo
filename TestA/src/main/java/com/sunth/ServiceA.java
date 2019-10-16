package com.sunth;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.codingapi.txlcn.tc.annotation.TxTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sunth
 * @DateTime 2019-10-11 9:58
 * 描述
 */
@Component
@Service
public class ServiceA {
    @Autowired
    private MapperA mapperA;
//    @Transactional(rollbackFor = Exception.class)
    @TxTransaction
    public int update(int money, String username) {
        return mapperA.update(money, username);
    }
}
