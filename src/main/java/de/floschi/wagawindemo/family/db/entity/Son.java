package de.floschi.wagawindemo.family.db.entity;

import lombok.Data;

import javax.persistence.Table;

@Table(name = "son")
@Data
public class Son extends Child {

    private String bicycleColor;

}
