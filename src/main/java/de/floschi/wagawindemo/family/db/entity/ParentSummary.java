package de.floschi.wagawindemo.family.db.entity;

import javax.persistence.Table;

@Table(name = "parentsummary")
public class ParentSummary {

    private Long amountOfPersons;
    private Long amountOfChildren;
}
