package de.floschi.wagawindemo.family.db.dao;

import de.floschi.wagawindemo.family.db.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildDao extends JpaRepository<Child, Long> {
}
