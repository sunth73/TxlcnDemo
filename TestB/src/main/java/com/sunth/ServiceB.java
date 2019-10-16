package com.sunth;

//import com.codingapi.txlcn.tc.annotation.LcnTransaction;
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
public class ServiceB {
    @Autowired
    private MapperB mapperB;
    @Autowired
    FeignClientB feignClientB;

//    @Transactional(rollbackFor = Exception.class)
    @TxTransaction
//    @GlobalTransactional
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
}
