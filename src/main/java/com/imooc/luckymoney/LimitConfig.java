package com.imooc.luckymoney;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@ConfigurationProperties(prefix = "limit")
public class LimitConfig {

    private BigDecimal minMoney;
    private BigDecimal maxMoney;

    public void setMinMoney(BigDecimal minMoney){
        this.minMoney = minMoney;
    }
    public void setMaxMoney(BigDecimal maxMoney){

        this.maxMoney = maxMoney;
    }

    public BigDecimal getMaxMoney(){

        return maxMoney;
    }

    public BigDecimal getMinMoney(){

        return minMoney;
    }

}
