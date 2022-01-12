package com.yingz.controller;

import com.yingz.dao.Admin;
import com.yingz.repository.AdminRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;

    @Value("${server.port}")
    private String port;

    @GetMapping("/findAll")
    public Collection<Admin> findAll(){
        return adminRepository.findAll();
    }

    @GetMapping("/findBy Id/{id}")
    public Admin findById(@PathVariable("id") Long id){
        return adminRepository.findById(id);
    }
    @PostMapping("/save")
    public void save(@RequestBody Admin admin){
        adminRepository.saveOrUpdate(admin);
    }
    @PutMapping("/update")
    public void Update(@RequestBody Admin admin){
        adminRepository.saveOrUpdate(admin);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id")Long id){
        adminRepository.deleteById(id);
    }

    @GetMapping("/index")
    public String index(){
        return "当前网关为："+this.port;
    }
}
