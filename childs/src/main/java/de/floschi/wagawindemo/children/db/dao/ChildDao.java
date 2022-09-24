package de.floschi.wagawindemo.children.db.dao;

import de.floschi.wagawindemo.children.db.entity.Child;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildDao extends JpaRepository<Child, Long> {
}
