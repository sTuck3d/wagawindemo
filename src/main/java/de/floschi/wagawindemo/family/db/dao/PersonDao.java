package de.floschi.wagawindemo.family.db.dao;

import de.floschi.wagawindemo.family.db.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<Person, Long> {

    @Query("select max(persons.children) from Person persons")
    int getMaxNumberOfChildren();

    @Query("select count(persons) from Person persons where count(persons.children) = ?1")
    int getNumberOfPersonsWithNumber(int numberOfChildren);

}
