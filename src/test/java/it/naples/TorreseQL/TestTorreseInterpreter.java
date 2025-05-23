package it.naples.TorreseQL;

import it.naples.TorreseQL.model.iDontKnow;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestTorreseInterpreter {
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

    @Test(expected = iDontKnow.class)
    public void testWrongDataTypeInsert() {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        interpreter.execute("");
    }

    @Test
    public void testSqlConversion() {
        String query = "";
        String preparedQuery = TorreseInterpreter.toSqlQuery(query);
        Assert.assertEquals("", preparedQuery);
    }

}
