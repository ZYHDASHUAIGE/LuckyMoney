package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository repository;

    /**
     * create two lucky money
     */
    @Transactional
    public void createTwo(){
        //first lucky money
        Luckymoney luckymoney1 = new Luckymoney();
        luckymoney1.setProducer("I");
        luckymoney1.setMoney(new BigDecimal(520));
        repository.save(luckymoney1);

        //second lucky money
        Luckymoney luckymoney2 = new Luckymoney();
        luckymoney2.setProducer("I");
        luckymoney2.setMoney(new BigDecimal(1314));
        repository.save(luckymoney2);
    }
}
