package org.openapitools.persistence.config;

import org.springframework.beans.factory.annotation.Value;

import javax.sql.DataSource;

public abstract class DatabaseConfigBase {

    protected static final String[] PACKAGES_TO_SCAN = new String[] { "org.openapitools.persistence.model" };

    protected @Value("${parasol.db.pool.maxActive:100}") int maxActive;
    protected @Value("${parasol.db.pool.maxWait:15000}") int maxWait;
    protected @Value("${parasol.dbname:parasoldb}") String parasolDbName;

    protected abstract DataSource makePooledDataSource() throws Exception;
}
