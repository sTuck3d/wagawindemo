package de.floschi.wagawindemo.family.db.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "parentsummary")
@Data
public class ParentSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_summary_id")
    private Long parentSummaryId;

    @Column(name = "amount_of_persons")
    private int amountOfPersons;

    @Column(name = "amount_of_children", unique = true)
    private int amountOfChildren;
}
