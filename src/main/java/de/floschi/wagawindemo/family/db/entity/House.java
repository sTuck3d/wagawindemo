package de.floschi.wagawindemo.family.db.entity;

import de.floschi.wagawindemo.family.data.HouseType;
import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Table(name = "House")
@Data
public class House {

    @Id
    @GeneratedValue
    @Column(name = "house_id")
    private Long houseId;

    @Column(name = "address")
    private String address;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private HouseType type; // TODO: Best practice enum in DB speichern?

    @OneToOne(mappedBy = "house")
    private Person person;
}
