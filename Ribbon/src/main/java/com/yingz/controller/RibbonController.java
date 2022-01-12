package com.yingz.controller;

import com.yingz.dao.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/ribbon")
public class RibbonController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Admin> findAll(){
        return restTemplate.getForObject("http://client/admin/findAll",Collection.class);
    }
    @GetMapping("/index")
    public String index(){
       return restTemplate.getForObject("http://client/admin/index",String.class);
    }
}
