package com.example;

import com.example.model.Employee;
import com.example.model.ProcModel;
import com.example.proxy.ErrorPropagationProxy;
import com.example.proxy.MybatisDemoProcProxy;
import com.example.proxy.MybatisDemoProxy;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CamelDemoApplication.class)
@WebAppConfiguration
public class CamelDemoApplicationTests {

    @Autowired
	ErrorPropagationProxy propagationProxy;

    @Autowired
    MybatisDemoProxy mybatisDemoProxy;

    @Autowired MybatisDemoProcProxy mybatisDemoProcProxy;

	@Test
	public void contextLoads() {
        try {
            propagationProxy.test();
        } catch (Exception e) {
            System.out.println();
        }
	}

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
