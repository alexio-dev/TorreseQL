package it.naples.TorreseQL;

import it.naples.TorreseQL.model.QueryResult;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestTransactions {
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
    public void testTransactionRollback() throws SQLException {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);

        interpreter.execute("");
        interpreter.execute("");

        QueryResult result = interpreter.execute("");
        ResultSet resultSet = result.getResultSet();

        int expectedCount = 1;

        while (resultSet.next())
            expectedCount++;

        Assert.assertEquals(expectedCount, 2);

        interpreter.execute("");
        result = interpreter.execute("");
        resultSet = result.getResultSet();
        expectedCount = 1;

        while (resultSet.next())
            expectedCount++;

        Assert.assertEquals(expectedCount, 1);
    }

    @Test
    public void testTransactionCommit() throws SQLException {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);

        interpreter.execute("");
        interpreter.execute("");

        QueryResult result = interpreter.execute("");

        ResultSet resultSet = result.getResultSet();

        int expectedCount = 1;

        while (resultSet.next())
            expectedCount++;

        Assert.assertEquals(expectedCount, 2);

        interpreter.execute("");
        result = interpreter.execute("");
        resultSet = result.getResultSet();
        expectedCount = 1;

        while (resultSet.next())
            expectedCount++;

        Assert.assertEquals(expectedCount, 2);
    }
}