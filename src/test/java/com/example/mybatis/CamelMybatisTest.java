package com.example.mybatis;

import com.example.AbstractAppInitializer;
import com.example.model.ProcModel;
import com.example.proxy.MybatisDemoProcProxy;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author Biplab Nayak [Created On 6/5/2016].
 */
public class CamelMybatisTest extends AbstractAppInitializer{


    @Autowired
    MybatisDemoProcProxy mybatisDemoProcProxy;

    @Test
    public void testMaxEmpId() {
        ProcModel req = new ProcModel();
        req.setInParam1("NJ");
        mybatisDemoProcProxy.getMaxSalary(req);
        System.out.println();

    }
}
