package de.floschi.wagawindemo.family.db.dao;

import de.floschi.wagawindemo.family.db.entity.Person;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepo extends R2dbcRepository<Person, Long> {
}
