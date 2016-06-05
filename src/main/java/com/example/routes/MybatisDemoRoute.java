package com.example.routes;

import com.example.model.Employee;
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

    }
}
