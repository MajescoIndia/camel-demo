package com.example.jdbc;

import com.example.AbstractAppInitializer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Biplab Nayak [Created On 6/5/2016].
 */
public abstract class AbstractJdbcTest extends AbstractAppInitializer{

    protected Connection connection;

    private static final String driver = "oracle.jdbc.driver.OracleDriver";
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String username = "hr";
    private static final String password = "hr";

    public AbstractJdbcTest(){
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
