package com.yingz.feign;


import com.yingz.dao.Admin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "client")
public interface FeognEirelaClient {

    @GetMapping("/admin/findAll")
    public Collection<Admin> findAll();

    @GetMapping("/admin/index")
    public String index();
}
