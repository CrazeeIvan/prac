package com.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcAccess {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public JdbcAccess(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		System.out.println("jdbcTemplate=" + jdbcTemplate);
		System.out.println(
		        "datasource=" + jdbcTemplate.getDataSource());
	}
}
