package com.yingz.feign.Impl;

import com.yingz.dao.Admin;
import com.yingz.feign.FeognEirelaClient;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
public class FeignError implements FeognEirelaClient {
    @Override
    public Collection<Admin> findAll() {
        return null;
    }

    @Override
    public String index() {
        return "服务器维护······";
    }
}
