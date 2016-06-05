package com.example.proxy;

import com.example.model.Employee;

import java.util.List;

/**
 * @author Biplab Nayak [Created On 6/5/2016].
 */
public interface MybatisDemoProxy {
    List<Employee> getEmpByJobId(String jobId);
}
