package com.ray.lab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringJdbcApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... strings) throws Exception {
		log.info("Creating tables via jdbcTemplate");
		jdbcTemplate.execute("DROP TABLE SIMPLE_OBJECTS IF EXISTS");
		jdbcTemplate.execute("CREATE TABLE SIMPLE_OBJECTS(id SERIAL, name VARCHAR(30), message VARCHAR(30))");
		log.info("Insert data");

		SimpleObject a = new SimpleObject("a", "message from a");
		SimpleObject b = new SimpleObject("b", "message from b");
		List<SimpleObject> objects = Arrays.asList(a, b);

		jdbcTemplate.batchUpdate("INSERT INTO SIMPLE_OBJECTS(name, message) VALUES (?,?)",
				new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
						preparedStatement.setString(1, objects.get(i).getName());
						preparedStatement.setString(2, objects.get(i).getMessage());
					}
					@Override
					public int getBatchSize() {
						return 2;
					}
				});

		log.info("Query data");
		jdbcTemplate.query(
				"SELECT id, name, message FROM SIMPLE_OBJECTS WHERE name = ?", new Object[] { "a" },
				(rs, rowNum) -> new SimpleObject(rs.getLong("id"), rs.getString("name"), rs.getString("message"))
		).forEach(simpleObject -> log.info(simpleObject.toString()));
	}
}
