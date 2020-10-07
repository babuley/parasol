package org.openapitools.persistence.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableJpaRepositories(basePackages = "org.openapitools.persistence.services")
@EnableTransactionManagement
public class PersistenceConfig {

    protected @Value("${parasol.db.pool.maxActive:100}") int maxActive;
    protected @Value("${parasol.db.pool.maxWait:15000}") int maxWait;
    protected @Value("${parasol.dbname:parasoldb}") String parasolDbName;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(makePooledDataSource());
        em.setPackagesToScan(new String[] { "org.openapitools.persistence.model" });

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }

    @Bean()
    protected DataSource makePooledDataSource() throws Exception
    {
        ComboPooledDataSource bean = new ComboPooledDataSource();
        bean.setDriverClass( "org.h2.Driver" );
        //bean.setJdbcUrl( "jdbc:h2:file:" +  "/database/" + parasolDbName );
        bean.setJdbcUrl( "jdbc:h2:mem:" + parasolDbName );
        // bean.setUser( "sa" );
        // bean.setPassword( "" );
        bean.setMaxPoolSize(maxActive);
        bean.setCheckoutTimeout(maxWait);
        return bean;
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws Exception {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        return properties;
    }
}
