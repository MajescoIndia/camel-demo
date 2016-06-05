package com.example.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @author Biplab Nayak [Created On 6/5/2016].
 */
public class JdbcProcedureTest extends AbstractJdbcTest{

    @Test
    public void testConnection() {
        Assert.assertNotNull("Connection Can not be null.", connection);
    }

    @Test
    public void testProcedureCall() throws SQLException {
        Integer max_sal;
        CallableStatement statement = connection.prepareCall("{call get_max_sal_job_id(?, ?)}");
        statement.setString(1, "IT_PROG");
        statement.registerOutParameter(2, Types.INTEGER);
        statement.execute();

        max_sal = statement.getInt(2);

        statement.close();
        connection.close();
        Assert.assertNotNull(max_sal);
    }
}
