package springmvc.java.controller;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DatabaseController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseController.class);

	@Autowired
	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	@RequestMapping(value = "/displayUsersMySQL")
	public void displayUser() {
		jdbcTemplate = new JdbcTemplate(dataSource);

		List<Map<String, Object>> users = jdbcTemplate.queryForList("SELECT * FROM USER");

		for (Map<String, Object> user : users) {
			LOGGER.debug("MySQL username: " + user.get("username"));
		}
	}
}
