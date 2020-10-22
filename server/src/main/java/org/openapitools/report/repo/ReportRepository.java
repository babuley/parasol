package org.openapitools.report.repo;


import org.openapitools.report.model.RecordItem;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CassandraRepository<RecordItem, Long> {
}
