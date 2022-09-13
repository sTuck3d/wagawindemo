package de.floschi.wagawindemo.family.db.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "parentsummary")
public class ParentSummary {

    @Id
    @GeneratedValue
    @Column(name = "parent_summary_id")
    private Long parentSummaryId;

    @Column(name = "amount_of_persons")
    private Long amountOfPersons;

    @Column(name = "amount_of_children")
    private Long amountOfChildren;
}
