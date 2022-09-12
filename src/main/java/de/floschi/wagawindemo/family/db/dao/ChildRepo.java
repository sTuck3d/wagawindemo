package de.floschi.wagawindemo.family.db.dao;

import de.floschi.wagawindemo.family.db.entity.Child;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepo extends R2dbcRepository<Child, Long> {
}
