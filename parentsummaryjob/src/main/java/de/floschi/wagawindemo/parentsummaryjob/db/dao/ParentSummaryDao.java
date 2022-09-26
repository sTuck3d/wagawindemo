package de.floschi.wagawindemo.parentsummaryjob.db.dao;

import de.floschi.wagawindemo.parentsummaryjob.db.entity.ParentSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentSummaryDao extends JpaRepository<ParentSummary, Long> {

    Optional<ParentSummary> findByAmountOfChildren(int numberOfChildren);

}
