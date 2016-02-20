package springmvc.java.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import springmvc.java.service.BlogPostService;
import springmvc.java.service.impl.BlogPostServiceImpl;

@EnableJpaRepositories(basePackages = "springmvc.java.dao")
@EnableTransactionManagement
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

	private DatabasePopulator databasePopulator() {
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
		databasePopulator.setContinueOnError(true);
		databasePopulator.addScript(new ClassPathResource("test-data.sql"));

		return databasePopulator;
	}

	@Bean
	public BlogPostService blogPostService() {
		return new BlogPostServiceImpl();
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);

		DatabasePopulatorUtils.execute(databasePopulator(), dataSource());

		return jpaTransactionManager;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
		jpaVendorAdapter.setDatabase(Database.MYSQL);
		jpaVendorAdapter.setShowSql(true);

		return jpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
		entityManager.setDataSource(dataSource());

		entityManager.setJpaVendorAdapter(jpaVendorAdapter());

		entityManager.setPackagesToScan("springmvc.java.domain");

		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");

		entityManager.setJpaProperties(jpaProperties);

		return entityManager;
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
