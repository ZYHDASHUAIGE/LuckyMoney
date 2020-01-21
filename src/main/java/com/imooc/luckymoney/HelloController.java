package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * Created by zyh
 * 2019-12-18 20:10
 */
@RestController
public class HelloController {
    @Autowired
    private LimitConfig limitConfig;

    @Value("${limit.minMoney}")
    private BigDecimal minMoney;

    //@GetMapping("/helloWorld")
    @RequestMapping(value = "/helloWorld",method = RequestMethod.GET)
    public String hello(){
        return "hello world!";
    }

    @ResponseBody
    @PostMapping(value = "/say")
    public String say(){
        return "index";
    }

    @GetMapping("/minMoney")
    public BigDecimal getMinMoney(){
        return limitConfig.getMinMoney();
    }

    @GetMapping("/say/{id}")
    public String getID(@PathVariable(value = "id") Integer id){
        return "ID:"+id;
    }

    @GetMapping("/sayID")
    public String sayID(@RequestParam(value = "id",required = false,defaultValue = "1") Integer id){
        return "ID:"+id;
    }

}
