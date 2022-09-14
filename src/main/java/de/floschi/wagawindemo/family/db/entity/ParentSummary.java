package de.floschi.wagawindemo.family.db.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "parentsummary")
@AllArgsConstructor
@NoArgsConstructor
public class ParentSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_summary_id")
    private Long parentSummaryId;

    @Column(name = "amount_of_persons")
    private Long amountOfPersons;

    @Column(name = "amount_of_children")
    private Long amountOfChildren;
}
