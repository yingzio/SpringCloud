package com.yingz.repository.Impl;

import com.yingz.dao.Admin;
import com.yingz.repository.AdminRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AdminRepositoryImpl implements AdminRepository {

    private static Map<Long,Admin> adminMap;
    static {
        adminMap=new HashMap<>();
        adminMap.put(2L,new Admin(2L,"admin2","123"));
        adminMap.put(3L,new Admin(3L,"admin3","123"));
        adminMap.put(4L,new Admin(4L,"admin4","123"));
    }

    @Override
    public Collection<Admin> findAll() {
        return adminMap.values();
    }

    @Override
    public Admin findById(Long id) {
        return adminMap.get(id);
    }

    @Override
    public void saveOrUpdate(Admin admin) {
        adminMap.put(admin.getId(),admin);
    }

    @Override
    public void deleteById(Long id) {
        adminMap.remove(id);
    }
}
