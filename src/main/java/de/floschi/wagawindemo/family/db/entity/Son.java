package de.floschi.wagawindemo.family.db.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "son")
@Data
public class Son extends Child {

    @Column(name = "bicycleColor")
    private String bicycleColor;

}
