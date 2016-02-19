package springmvc.java.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class ApplicationContext {
	
	@Autowired
	private Environment enviroment;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(enviroment.getProperty("jdbc.driverClass"));
		dataSource.setUrl(enviroment.getProperty("jdbc.url"));
		dataSource.setUsername(enviroment.getProperty("jdbc.username"));
		dataSource.setPassword(enviroment.getProperty("jdbc.password"));
		
		return dataSource;
	}

	// @Bean
	// public DataSource dataSource() {
	// EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
	// EmbeddedDatabase embeddedDatabase = builder
	// .setType(EmbeddedDatabaseType.HSQL)
	// .addScript("dbschema.sql")
	// .addScript("test-data.sql")
	// .build();
	// return embeddedDatabase;
	// }
}
