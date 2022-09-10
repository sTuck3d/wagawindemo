package de.floschi.wagawindemo.family.db.dao;

import de.floschi.wagawindemo.family.db.entity.House;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepo extends ReactiveCrudRepository<House, Long> {
}
