package com.turling.service;

import com.turling.entity.Emp;

import java.util.List;

/**
 * 员工业务逻辑类
 */
public interface EmpService {
    /**
     * 检查用户名是否合法
     * @param username
     * @return
     */
    public boolean checkUserName(String username);

    public List<Emp> findAll();
}
