package org.openapitools.persistence.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@Profile("database/h2")
public class H2Config extends DatabaseConfigBase {

    @Bean()
    protected DataSource makePooledDataSource() throws Exception
    {
        ComboPooledDataSource bean = new ComboPooledDataSource();
        bean.setDriverClass( "org.h2.Driver" );
        bean.setJdbcUrl( "jdbc:h2:mem:" + parasolDbName );
        bean.setMaxPoolSize(maxActive);
        bean.setCheckoutTimeout(maxWait);
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
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        return properties;
    }

}
