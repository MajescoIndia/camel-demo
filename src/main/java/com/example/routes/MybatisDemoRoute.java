package com.example.routes;

import com.example.model.ProcModel;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Biplab Nayak [Created On 6/5/2016].
 */

@Component
public class MybatisDemoRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("direct:mybatisDemoClassCodeProc")
                .convertBodyTo(ProcModel.class)
                .to("mybatis:selectClassCodeByStateCode?statementType=SelectOne")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println();
                    }
                });

    }
}
