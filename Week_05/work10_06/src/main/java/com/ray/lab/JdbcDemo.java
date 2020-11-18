package com.ray.lab;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

public class JdbcDemo {

    private static final Logger log = LoggerFactory.getLogger(JdbcDemo.class);

    public Connection getJDBCConnection(){
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:mem:db", "SA", "");
            connection.setAutoCommit(false);
        } catch (Exception e) {
            log.error("Open connection failed", e);
        }
        return connection;
    }

    public void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            log.error("Close connection failed", e);
        }
    }

    public void createTables(Connection connection){
        try {
            log.info("Creating table");
            connection.createStatement().executeUpdate("DROP TABLE SIMPLE_OBJECTS IF EXISTS");
            connection.createStatement().executeUpdate("CREATE TABLE SIMPLE_OBJECTS(id SERIAL, name VARCHAR(30), message VARCHAR(30))");
        } catch ( SQLException e) {
            log.error("Create table failed", e);
        }
    }

    public void insertUsingStatement(Connection connection) {
        log.info("Insert data via statement");
        String insertObjectSQL = "INSERT INTO SIMPLE_OBJECTS(name, message) VALUES ('%s', '%s');";
        try (Statement statement = connection.createStatement()){
            statement.addBatch(String.format(insertObjectSQL, "a", "message from a"));
            statement.addBatch(String.format(insertObjectSQL, "b", "message from b"));
            statement.executeBatch();
            connection.commit();
        } catch (Exception e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                log.error("Error during rollback");
                log.error(ex.getMessage());
            }
            log.error("InsertData failed");
        }
    }

    public void fetchUsingStatement(Connection connection){
        log.info("Fetch data via statement");
        String fetchSQL = "SELECT id, name, message FROM SIMPLE_OBJECTS";
        try (Statement statement  =connection.createStatement()){
            try(ResultSet resultSet = statement.executeQuery(fetchSQL)) {
                while (resultSet.next()) {
                    SimpleObject object = new SimpleObject(
                            resultSet.getLong("id"),
                            resultSet.getString("name"),
                            resultSet.getString("message"));
                    log.info(object.toString());
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void insertUsingPreparedStatement(Connection connection){
        log.info("Insert data via PreparedStatement");
        String INSERT_SQL = "INSERT INTO SIMPLE_OBJECTS(name, message) VALUES (?, ?)";
        try (PreparedStatement pst = connection.prepareStatement( INSERT_SQL )) {
            List<String> objects = Arrays.asList("c", "d", "e");
            for (String so: objects) {
                pst.setString(1, so);
                pst.setString(2, "message from "+ so);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            log.error("Insert data failed", e);
            try {
                connection.rollback();
            } catch (SQLException ex) {
                log.error("Error during rollback");
                log.error(ex.getMessage());
            }
        }
    }

    private void fetchUsingPreparedStatement(Connection connection) {
        log.info("Fetch data via PreparedStatement");
        String FETCH_SQL = "SELECT id, name, message FROM SIMPLE_OBJECTS WHERE name=?";
        try(PreparedStatement pst = connection.prepareStatement(FETCH_SQL)) {
            pst.setString(1, "c");
            pst.executeQuery();
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                SimpleObject object = new SimpleObject(
                        resultSet.getLong("id"),
                        resultSet.getString("name"),
                        resultSet.getString("message"));
                log.info(object.toString());
            }
        } catch (SQLException e) {
            log.error("Fetch data failed", e);
        }
    }

    public Connection getHikariConnection(){
        Connection connection = null;
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:h2:mem:db");
        config.setUsername("SA");
        config.setPassword("");
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        HikariDataSource ds = new HikariDataSource(config);
        try {
            connection = ds.getConnection();
        } catch (SQLException e) {
            log.error("Open Hikari connection failed", e);
        }
        return connection;
    }

    public static void main(String[] args) {
        JdbcDemo demo = new JdbcDemo();

        Connection conn = demo.getJDBCConnection();
        demo.createTables(conn);
        demo.insertUsingStatement(conn);
        demo.fetchUsingStatement(conn);
        demo.insertUsingPreparedStatement(conn);
        demo.fetchUsingPreparedStatement(conn);
        demo.closeConnection(conn);

        Connection hconn = demo.getHikariConnection();
        demo.createTables(hconn);
        demo.insertUsingStatement(hconn);
        demo.fetchUsingStatement(hconn);
        demo.insertUsingPreparedStatement(hconn);
        demo.fetchUsingPreparedStatement(hconn);
        demo.closeConnection(hconn);
    }
}
