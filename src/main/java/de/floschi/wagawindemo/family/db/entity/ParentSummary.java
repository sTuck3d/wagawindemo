package de.floschi.wagawindemo.family.db.entity;

import org.springframework.data.relational.core.mapping.Table;

@Table("parentsummary")
public class ParentSummary {

    private Long amountOfPersons;
    private Long amountOfChildren;
}
