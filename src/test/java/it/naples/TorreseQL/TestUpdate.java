package it.naples.TorreseQL;

import it.naples.TorreseQL.model.QueryResult;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestUpdate {
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
    public void testUpdateAll() throws SQLException {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        QueryResult result = interpreter.execute("");
        Assert.assertEquals((Integer) 4, result.getAffectedRows());

        result = interpreter.execute("");
        ResultSet resultSet = result.getResultSet();

        int counter = 0;

        while (resultSet.next()) {
            int id = resultSet.getInt(1);

            Assert.assertEquals(10, id);
            counter++;
        }

        Assert.assertEquals(4, counter);
    }

    @Test
    public void testUpdateWhere() throws SQLException {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        QueryResult result = interpreter.execute("");
        Assert.assertEquals((Integer) 1, result.getAffectedRows());

        result = interpreter.execute("");
        ResultSet resultSet = result.getResultSet();

        int counter = 0;
        while (resultSet.next()) {
            int id = resultSet.getInt(1);

            Assert.assertEquals(10, id);
            counter++;
        }

        Assert.assertEquals(1, counter);
    }

}