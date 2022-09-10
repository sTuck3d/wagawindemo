package de.floschi.wagawindemo.family.db.entity;

import de.floschi.wagawindemo.family.data.HouseType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("house")
@Data
public class House {

    @Id
    private Long houseId;

    private String address;

    private String zipCode;

    private HouseType type; // TODO: Best practice enum in DB speichern?
}
