package it.naples.TorreseQL;

import it.naples.TorreseQL.model.QueryResult;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestInsert {
    final String JDBC = "";

    private Connection connection;

    @Before
    public void setup() throws SQLException {
        this.connection = Config.getConnection(JDBC);
    }

    @After
    public void teardown() throws SQLException {
        this.connection.close();
    }

    @Test
    public void testInsert() throws SQLException {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        QueryResult result = interpreter.execute("");
        Assert.assertEquals((Integer) 1, result.getAffectedRows());

        result = interpreter.execute("");
        ResultSet resultSet = result.getResultSet();

        int counter = 0;

        while (resultSet.next())
            counter++;

        Assert.assertEquals(1, counter);
    }

    @Test
    public void testInsertWithColumnNames() throws SQLException {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        QueryResult result = interpreter.execute("");
        Assert.assertEquals((Integer) 1, result.getAffectedRows());

        result = interpreter.execute("");
        ResultSet resultSet = result.getResultSet();

        int counter = 0;

        while (resultSet.next())
            counter++;

        Assert.assertEquals(1, counter);
    }

}