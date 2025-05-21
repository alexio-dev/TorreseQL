package it.naples.TorreseQL;

import it.naples.TorreseQL.model.iDontKnow;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class TestWrongSyntax {
    private Connection connection;

    final String JDBC = "";

    @Before
    public void setup() throws SQLException {
        this.connection = Config.getConnection(JDBC);
    }

    @After
    public void teardown() throws SQLException {
        this.connection.close();
    }

    @Test(expected = iDontKnow.class)
    public void testWrongInitialKeyword() {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        interpreter.execute("");
    }

    @Test(expected = iDontKnow.class)
    public void testSelectDoubleComma() {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        interpreter.execute("");
    }

    @Test(expected = iDontKnow.class)
    public void testSelectWrongFrom() {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        interpreter.execute("");
    }

    @Test(expected = iDontKnow.class)
    public void testQueryEndExpected() {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        interpreter.execute("");
    }

    @Test(expected = iDontKnow.class)
    public void testWrongLongOperator() {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        interpreter.execute("");
    }

    @Test(expected = iDontKnow.class)
    public void testIncompleteQuery() {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        interpreter.execute("");
    }

    @Test(expected = iDontKnow.class)
    public void testWhereInvalidOperator() {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        interpreter.execute("");
    }

    @Test(expected = iDontKnow.class)
    public void testWrongSelectWhereJoinOperator() {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        interpreter.execute("");
    }

    @Test(expected = iDontKnow.class)
    public void testWrongSelectWhereClause() {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        interpreter.execute("");
    }

    @Test(expected = iDontKnow.class)
    public void testWrongUpdateSetClause() {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        interpreter.execute("");
    }

    @Test(expected = iDontKnow.class)
    public void testWrongUpdateWhereClause() {
        TorreseInterpreter interpreter = new TorreseInterpreter(connection);
        interpreter.execute("");
    }
}