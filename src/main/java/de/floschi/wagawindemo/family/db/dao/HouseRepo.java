package de.floschi.wagawindemo.family.db.dao;

import de.floschi.wagawindemo.family.db.entity.House;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepo extends CrudRepository<House, Long> {
}
