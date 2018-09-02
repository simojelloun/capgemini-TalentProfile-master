package com.capgemini.talentProfile.app;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * The Class talentProfileApplication.
 *
 * @author Mohamed BENJELLOUN
 */
@SpringBootApplication
@ComponentScan({"com.capgemini.talentProfile", "com.capgemini.talentProfile.services", "com.capgemini.talentProfile.api.mappers", "com.capgemini.talentProfile.api.rest"})
@EnableJpaRepositories("com.capgemini.talentProfile.repository")
@EntityScan("com.capgemini.talentProfile.persistant")
@ImportResource("applicationContext.xml")
public class talentProfileApplication {

	/** The Constant logger. */
	private static final Logger LOGGER = Logger.getLogger(talentProfileApplication.class);

	@Value("${spring.datasource.driverclassname}")
	private String dbDriverClassName;

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String dbUsername;

	@Value("${spring.datasource.password}")
	private String dbPassword;

	private static String username;

	private static String password;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dbDriverClassName);
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);

		LOGGER.info("dataSource url: " + dataSource.getUrl());
		return dataSource;
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {

		if (args.length > 0) {
			if (StringUtils.isNotBlank(args[0])) {
				username = args[0];
			}
			if (StringUtils.isNotBlank(args[1])) {
				password = args[1];
			}
		}

		LOGGER.info("+ Démarrage du conteneur embarqué");
		new SpringApplicationBuilder(talentProfileApplication.class).run(args);
		LOGGER.info("- Démarrage du conteneur embarqué");

	}

}
