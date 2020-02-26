package io.java.config;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 
 * @author Nilesh M Configuring EntityManagerFactoryBean AND Datasource For
 *         StudentRepository
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "studentEntityMangerFactoryBean", 
													transactionManagerRef = "oracleTransactionManager", 
													basePackages = {"io.java.student.repository" })
public class StudentConfig {

	@Bean(name = "studentEntityMangerFactoryBean")
	public LocalContainerEntityManagerFactoryBean entityMangerFactoryBean() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		// setDatasourceDor FactoryBean
		emf.setDataSource(oracleDatasource());
		// set Entity Classes ToScan
		emf.setPackagesToScan(new String[] { "io.java.entity" });
		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);
		// return factory instance
		return emf;
	}// EntityManagerFactory

	/**
	 * 
	 * @return DataSource For MySQL
	 */
	/*
	 * @Bean(name = "oracleDs")
	 * 
	 * @Primary
	 * 
	 * @ConfigurationProperties(prefix = "oracle.datasource1") public DataSource
	 * oracleDatasource() { return DataSourceBuilder.create().build(); }//
	 * mysqldatasource
	 */

	@Bean
	public DataSource oracleDatasource() {
		return DataSourceBuilder.create().url("jdbc:oracle:thin:@localhost:1521:SYSTEM")
				.driverClassName("oracle.jdbc.driver.OracleDriver").username("system").password("manager").build();
	}

	/**
	 * 
	 * @param emf
	 * @return PlatformTransactionManger
	 */
	@Bean(name = "oracleTransactionManager")
	public PlatformTransactionManager getTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager jptm = new JpaTransactionManager();
		jptm.setEntityManagerFactory(emf);
		// return TransactionManager
		return jptm;
	}// getTransactionManager

}// StudentConfig
