package de.floschi.wagawindemo.family.db.dao;

import de.floschi.wagawindemo.family.db.entity.ParentSummary;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentSummaryDao extends R2dbcRepository<ParentSummary, Long> {
}
