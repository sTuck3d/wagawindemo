package de.floschi.wagawindemo.family.db.entity;

import lombok.Data;
import org.springframework.data.relational.core.mapping.Table;

@Table("son")
@Data
public class Son extends Child {

    private String bicycleColor;

}
