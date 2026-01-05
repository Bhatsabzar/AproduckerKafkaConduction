package com.Aconduction.Controller;


import com.Aconduction.Entity.Consumer;
import com.Aconduction.Repository.ConsumerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consume")
public class ConsumerController {
    @Autowired
    ConsumerRepository consumerRepository;


    @GetMapping("/get")
    public List<Consumer> getAll(){
        return consumerRepository.findAll();
    }
}
