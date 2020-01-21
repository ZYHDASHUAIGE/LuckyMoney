package com.imooc.luckymoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService service;
    /**
     * get luckymoney list
     */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> list() {
        return repository.findAll();
    }

    /**
     * hand out luckymoney
     */
    @PostMapping("/luckymoenys")
    public Luckymoney create(@RequestParam("producer") String producer, @RequestParam("money") BigDecimal money) {

        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);
        return repository.save(luckymoney);
    }

    /**
     * find luckymoeny by ID
     */
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findByID(@PathVariable(value = "id") Integer id) {

        return repository.findById(id).orElse(null);
    }

    /**
     * receive luckymoeny
     */
    @PutMapping("/luckymoenys/{id}")
    public Luckymoney update(@PathVariable(value = "id") Integer id, @RequestParam(value = "consumer") String consumer) {
        Optional<Luckymoney> optional = repository.findById(id);
        if(optional.isPresent()){
            Luckymoney luckymoney = optional.get();
            //luckymoney.setId(id);
            luckymoney.setConsumer(consumer);
            return repository.save(luckymoney);
        }else {
            return null;
        }
    }

    @PostMapping("/luckymoenys/two")
    public void createTwo(){
        service.createTwo();
    }
}
