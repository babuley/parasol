package org.openapitools.persistence.config;


import com.datastax.oss.driver.api.core.CqlSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;


import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
@Profile("database/cassandra")
@EnableCassandraRepositories(basePackages = "org.openapitools.report.repo")
public class CassandraConfig extends AbstractCassandraConfiguration   {

    private static final Logger LOG = LoggerFactory.getLogger(CassandraConfig.class);


    @Value("${spring.data.cassandra.keyspace-name:parasol}")
    private String keyspaceName;

    @Value("${spring.data.cassandra.port:9042}")
    private Integer port;

    @Value("${spring.data.cassandra.contact-points:127.0.01}")
    private String contactPoints;

    @Value("${spring.data.cassandra.local-datacenter:datacenter1}")
    private String datacenter;

    @Value("${cassandra.basePackages:org.openapitools.report.model}")
    private String basePackages;

    @Override
    protected String getKeyspaceName() {
        return keyspaceName;
    }

    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    protected String getLocalDataCenter() {
        return datacenter;
    }

    private List<InetSocketAddress> resolveContactPoints(){
        return Stream.of(contactPoints.split(",")).map(host-> {
            return new InetSocketAddress(host, port);}
        ).collect(Collectors.toList());
    }


    @Override
    protected CqlSession getRequiredSession() {
        List<InetSocketAddress> hostList = resolveContactPoints();
        return CqlSession.builder()
                .withLocalDatacenter(datacenter)
                .addContactPoints(hostList)
               // .withAuthCredentials(username, password)
                .withKeyspace(keyspaceName)
                .build();
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[] {basePackages};
    }
//
//
//    @Override
//    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
//        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(keyspaceName)
//                .ifNotExists()
//                .with(KeyspaceOption.DURABLE_WRITES, true)
//                .withSimpleReplication();
//                //.withNetworkReplication(DataCenterReplication.of("datacenter1", 1), DataCenterReplication.of("datacenter2", 2));
//        return Arrays.asList(specification);
//    }
//
//    @Override
//    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
//        return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(keyspaceName));
//    }
//
//    @Bean
//    public CqlSessionFactoryBean session() {
//        CqlSessionFactoryBean session = new CqlSessionFactoryBean();
//        session.setContactPoints(contactPoints);
//        session.setLocalDatacenter(datacenter);
//        session.setKeyspaceName(keyspaceName);
//        return session;
//    }
//
//    @Bean
//    public SessionFactoryFactoryBean sessionFactory(CqlSession session, CassandraConverter converter) {
//        SessionFactoryFactoryBean sessionFactory = new SessionFactoryFactoryBean();
//        sessionFactory.setSession(session);
//        sessionFactory.setConverter(converter);
//        sessionFactory.setSchemaAction(SchemaAction.CREATE_IF_NOT_EXISTS);
//
//        return sessionFactory;
//    }
//
//    @Bean
//    public CassandraMappingContext mappingContext(CqlSession cqlSession) {
//
//        CassandraMappingContext mappingContext = new CassandraMappingContext();
//        mappingContext.setUserTypeResolver(new SimpleUserTypeResolver(cqlSession));
//
//        return mappingContext;
//    }
//
//    @Bean
//    public CassandraConverter converter(CassandraMappingContext mappingContext) {
//        return new MappingCassandraConverter(mappingContext);
//    }
//
//    @Bean
//    public CassandraOperations cassandraTemplate(SessionFactory sessionFactory, CassandraConverter converter) {
//        return new CassandraTemplate(sessionFactory, converter);
//    }


}
