package de.floschi.wagawindemo.family.db.dao;

import de.floschi.wagawindemo.family.db.entity.Child;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildRepo extends ReactiveCrudRepository<Child, Long> {
}
