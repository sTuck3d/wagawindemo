package de.floschi.wagawindemo.family.db.dao;

import de.floschi.wagawindemo.family.db.entity.ParentSummary;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentSummaryDao extends ReactiveCrudRepository<ParentSummary, Long> {
}
