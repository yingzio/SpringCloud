package com.yingz.controller;

import com.yingz.dao.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {
    @Autowired
    public RestTemplate restTemplate;

    @GetMapping("/findAll")
    public Collection<Admin> findAll(){
        return restTemplate.getForEntity("http://localhost:8010/admin/findAll",Collection.class).getBody();
    }

    @GetMapping("/findAll2")
    public Collection<Admin> findAll2(){
        return restTemplate.getForObject("http://localhost:8010/admin/findAll",Collection.class);
    }

    @GetMapping("/findById/{id}")
    public Admin findById(@PathVariable("id") long id){
        return restTemplate.getForEntity("http://localhost:8010/admin/findById/{id}",Admin.class,id).getBody();
    }

    @GetMapping("/findById2/{id}")
    public Admin findById2(@PathVariable("id") long id){
        return restTemplate.getForObject("http://localhost:8010/admin/findById/{id}",Admin.class,id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Admin admin){
        restTemplate.postForEntity("http://localhost:8010/admin/save",admin,void.class).getBody();
    }

    @PostMapping("/save2")
    public void save2(@RequestBody Admin admin){
        restTemplate.postForObject("http://localhost:8010/admin/save",admin,void.class);
    }

    @PutMapping("/update")
    public void update(@RequestBody Admin admin){
        restTemplate.put("http://localhost:8010/admin/update",admin);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        restTemplate.delete("http://localhost:8010/admin/deleteById/{id}",id);
    }

    @Value("${server.port}")
    private String port;
    @GetMapping("/index")
    public String index(){
        return "当前网关为："+this.port;
    }
}
