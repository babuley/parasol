package org.openapitools.persistence.services;

import org.openapitools.persistence.model.RecordDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<RecordDAO, Long> {
}
