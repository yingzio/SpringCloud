package com.yingz.controller;

import com.yingz.dao.Admin;
import com.yingz.feign.FeognEirelaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {

    @Autowired
    private FeognEirelaClient feognEirelaClient;

    @GetMapping("/findAll")
    public Collection<Admin> findAll(){
        return feognEirelaClient.findAll();
    }

    @GetMapping("/index")
    public String index() {
        return feognEirelaClient.index();
    }

}
