package com.example.exception;

import com.example.proxy.ErrorPropagationProxy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Biplab Nayak [Created On 6/5/2016].
 */
public class CamelErrorPropagationTest {

    @Autowired
    ErrorPropagationProxy propagationProxy;

    public void testErrorPropagation() {
        try {
            propagationProxy.test();
        } catch (Exception e) {
            System.out.println();
        }
    }
}
