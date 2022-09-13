package de.floschi.wagawindemo.family.db.entity;

import de.floschi.wagawindemo.family.data.HouseType;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "House")
@Data
public class House {

    @Id
    @Column(name = "house_id")
    private Long houseId;

    @Column(name = "address")
    private String address;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "type")
    private HouseType type; // TODO: Best practice enum in DB speichern?
}
