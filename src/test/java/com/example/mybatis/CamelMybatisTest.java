package com.example.mybatis;

import com.example.AbstractAppInitializer;
import com.example.model.Employee;
import com.example.model.ProcModel;
import com.example.proxy.MybatisDemoProcProxy;
import com.example.proxy.MybatisDemoProxy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Biplab Nayak [Created On 6/5/2016].
 */
public class CamelMybatisTest extends AbstractAppInitializer{

    @Autowired
    MybatisDemoProxy mybatisDemoProxy;

    @Autowired
    MybatisDemoProcProxy mybatisDemoProcProxy;


    @Test
    public void testMybatisSelect() {
        List<Employee> employees = mybatisDemoProxy.getEmpByJobId("IT_PROG");
        System.out.println();
    }

    @Test
    public void testMaxEmpId() {
        ProcModel req = new ProcModel();
        req.setInParam1("IT_PROG");
        mybatisDemoProcProxy.getMaxSalary(req);
    }

}
