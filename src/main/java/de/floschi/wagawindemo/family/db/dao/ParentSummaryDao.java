package de.floschi.wagawindemo.family.db.dao;

import de.floschi.wagawindemo.family.db.entity.ParentSummary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParentSummaryDao extends CrudRepository<ParentSummary, Long> {
}
