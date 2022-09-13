package de.floschi.wagawindemo.family.db.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "daughter")
@Data
public class Daughter extends Child { // TODO: Extenden bei DB eine gute Idee?

    @Column(name = "haircolor")
    private String hairColor;

}
