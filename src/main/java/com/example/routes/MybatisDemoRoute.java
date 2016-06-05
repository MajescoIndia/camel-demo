package com.example.routes;

import com.example.model.Employee;
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

        from("direct:mybatisDemoSelectEmployee").routeId("mybatisDemoSelectEmployee")
                .log("Fetching Data from DB.")
                .convertBodyTo(String.class)
                .to("mybatis:selectEmployeeByJobId?statementType=SelectList")
                .convertBodyTo(List.class);

        from("direct:mybatisDemoMaxSalProc")
                .convertBodyTo(ProcModel.class)
                .to("mybatis:selectMaxSalByJobIdProc?statementType=SelectOne")
                //.to("mybatis:selectEmpListByJobIdProc?statementType=SelectOne")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println();
                    }
                });

    }
}
