package org.openapitools.persistence.nosql.mongo;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
public class MongoConfig  {

    @Bean
    public MongoClient mongoClient() {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/parasoldb");
        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
                .credential(MongoCredential.createCredential("mongo", "admin","pa55word".toCharArray()))

                .applyConnectionString(connectionString)
                .build();

        return MongoClients.create(mongoClientSettings);
    }

    @Bean
    public MongoTemplate mongoTemplate() throws Exception {
        return new MongoTemplate(mongoClient(), "parasoldb");
    }
    //
//    @Override
//    public Collection getMappingBasePackages() {
//        return Collections.singleton("");
//    }

}