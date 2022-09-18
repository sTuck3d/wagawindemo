package de.floschi.wagawindemo.family.db.dao;

import de.floschi.wagawindemo.family.db.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HouseDao extends JpaRepository<House, Long> {

    @Query("SELECT h FROM House h WHERE h.person.personId= ?1")
    Optional<House> loadAllByPersonId(Long personId);
}
