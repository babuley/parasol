package org.openapitools.persistence.nosql.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
public class MongoConfig  {

    private static final Logger log = LoggerFactory.getLogger(MongoConfig.class);

    protected @Value("${parasol.mongo.dbname:parasoldb}") String parasolDbName;

    protected @Value("${parasol.mongo.db.host:mongo}") String dbHost;
    protected @Value("${parasol.mongo.db.port:27017}") int dbPort;

    protected @Value("${parasol.db.user:mongo}") String dbUser;
    protected @Value("${parasol.db.password:pa55word}") String dbPassword;

    @Bean
    public MongoClient mongoClient() {
        String mongoUri = String.format("mongodb://%s:%d/%s", dbHost, dbPort, parasolDbName);
        ConnectionString connectionString = new ConnectionString(mongoUri);
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .credential(MongoCredential.createCredential(dbUser, "admin",dbPassword.toCharArray()))

                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        try {
            return new MongoTemplate(mongoClient(), parasolDbName);
        } catch (Exception e) {
            log.error("Error on bootstrapping [mongo] wiring - likely configuration issue", e);
            throw e;
        }
    }
    //
//    @Override
//    public Collection getMappingBasePackages() {
//        return Collections.singleton("");
//    }

}