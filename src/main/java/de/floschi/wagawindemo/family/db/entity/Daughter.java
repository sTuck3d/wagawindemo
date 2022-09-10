package de.floschi.wagawindemo.family.db.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("daughter")
@Data
public class Daughter extends Child { // TODO: Extenden bei DB eine gute Idee?

    @Column("haircolor")
    private String hairColor;

}
