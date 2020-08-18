package com.turling.service.impl;

import com.turling.config.RootConfig;
import com.turling.entity.Emp;
import com.turling.entity.EmpExample;
import com.turling.mapper.EmpMapper;
import com.turling.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工业务逻辑实现类
 */
@Service
public class EmpServiceImpl implements EmpService {
    /*
    Could not autowire.No beans of 'xxxMapper' type found
    @Mapper 这个注解是 Mybatis 提供的
    @Autowried 注解是 Spring 提供的
    IDEA能理解 Spring 的上下文，但是却和 Mybatis 关联不上。
    而且我们可以根据 @Autowried 源码看到，默认情况下，@Autowried 要求依赖对象必须存在，那么此时 IDEA 只能给个红色警告了。
    解决方法:
    1.@Autowired(required = false)
    2.@Autowried替换为@Resource
    3.在Mapper接口上加@Component
    */
    @Autowired
    private EmpMapper empMapper;
    @Override
    public boolean checkUserName(String username) {
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEnameEqualTo(username);
        List<Emp> list = empMapper.selectByExample(empExample);
        if (list.size()>0){
            return true;
        }else {
            return  false;
        }
    }

    @Override
    public List<Emp> findAll() {
        return empMapper.selectByExample(null);
    }

}
