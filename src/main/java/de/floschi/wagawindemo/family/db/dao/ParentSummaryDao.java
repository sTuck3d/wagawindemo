package de.floschi.wagawindemo.family.db.dao;

import de.floschi.wagawindemo.family.db.entity.ParentSummary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ParentSummaryDao extends JpaRepository<ParentSummary, Long> {

    // @Query("select count(ps) from ParentSummary ps where ps.amountOfChildren = ?1")
    Optional<ParentSummary> findByAmountOfChildren(int numberOfChildren);

}
