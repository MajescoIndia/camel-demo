package com.example.proxy;

import com.example.exceptions.IrrecoverableException;

/**
 * @author Biplab Nayak [Created on 6/3/2016].
 */
public interface ErrorPropagationProxy {

    public void test() throws IrrecoverableException;
}
