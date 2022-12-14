package de.floschi.wagawindemo.parentsummaryjob.db.dao;

import de.floschi.wagawindemo.parentsummaryjob.db.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonDao extends JpaRepository<Person, Long> {

    @Query("select max(size(persons.children)) from Person persons")
    int getMaxNumberOfChildren();

    @Query("select count(persons) from Person persons where size(persons.children) = ?1")
    int getNumberOfPersonsWithNumber(int numberOfChildren);

}
