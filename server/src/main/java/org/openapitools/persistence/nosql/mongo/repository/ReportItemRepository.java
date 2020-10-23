package org.openapitools.persistence.nosql.mongo.repository;

import org.openapitools.persistence.nosql.mongo.model.ReportItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportItemRepository extends MongoRepository<ReportItem, Long> {
}
