package com.yingz.repository;

import com.yingz.dao.Admin;

import java.util.Collection;

public interface AdminRepository {
    public Collection<Admin> findAll();
    public Admin findById(Long id);
    public void saveOrUpdate(Admin admin);
    public void deleteById(Long id);
}
