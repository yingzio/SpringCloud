package com.yingz.feign;


import com.yingz.dao.Admin;
import com.yingz.feign.Impl.FeignError;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@FeignClient(value = "client",fallback = FeignError.class)
public interface FeognEirelaClient {

    @GetMapping("/admin/findAll")
    public Collection<Admin> findAll();

    @GetMapping("/admin/index")
    public String index();
}
