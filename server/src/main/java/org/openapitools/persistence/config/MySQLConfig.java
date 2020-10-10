package org.openapitools.persistence.config;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Profile("database/mysql")
public class MySQLConfig extends DatabaseConfigBase {


    protected @Value("${parasol.db.host:parasoldb}") String dbHost;
    protected @Value("${parasol.db.port:3306}") int dbPort;

    protected @Value("${parasol.db.user:root}") String dbUser;
    protected @Value("${parasol.db.password:Gr33nAnaconda}") String dbPassword;

    @Bean()
    protected DataSource makePooledDataSource() throws Exception
    {
        ComboPooledDataSource bean = new ComboPooledDataSource();
        bean.setDriverClass( "com.mysql.jdbc.Driver" );

        String jdbcUrl = String.format("jdbc:mysql://%s:%d/%s?createDatabaseIfNotExist=true&useSSL=false", dbHost, dbPort, parasolDbName);

        bean.setJdbcUrl(jdbcUrl);
        bean.setUser( dbUser);
        bean.setPassword( dbPassword);
        bean.setMaxPoolSize(maxActive);
        return bean;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws Exception {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(makePooledDataSource());
        em.setPackagesToScan(PACKAGES_TO_SCAN);

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(additionalProperties());
        return em;
    }


    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "create");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");

        return properties;
    }
}
