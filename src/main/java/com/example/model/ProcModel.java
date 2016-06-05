package com.example.model;

import java.util.List;

/**
 * @author Biplab Nayak [Created On 6/5/2016].
 */
public class ProcModel {

    private String inParam1;
    private String inParam2;
    private Integer outParam1;
    private String outParam2;
    private String inOutParam1;
    private List<Employee> employees;
    private Params inParams;
    private Params outParams;

    public Params getInParams() {
        return inParams;
    }

    public void setInParams(Params inParams) {
        this.inParams = inParams;
    }

    public Params getOutParams() {
        return outParams;
    }

    public void setOutParams(Params outParams) {
        this.outParams = outParams;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getInParam1() {
        return inParam1;
    }

    public void setInParam1(String inParam1) {
        this.inParam1 = inParam1;
    }

    public String getInParam2() {
        return inParam2;
    }

    public void setInParam2(String inParam2) {
        this.inParam2 = inParam2;
    }

    public Integer getOutParam1() {
        return outParam1;
    }

    public void setOutParam1(Integer outParam1) {
        this.outParam1 = outParam1;
    }

    public String getOutParam2() {
        return outParam2;
    }

    public void setOutParam2(String outParam2) {
        this.outParam2 = outParam2;
    }

    public String getInOutParam1() {
        return inOutParam1;
    }

    public void setInOutParam1(String inOutParam1) {
        this.inOutParam1 = inOutParam1;
    }
}
