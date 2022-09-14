package de.floschi.wagawindemo.family.db.entity;

import de.floschi.wagawindemo.family.data.HouseType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "house")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "house_id")
    private Long houseId;

    @Column(name = "address")
    private String address;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private HouseType type;

    @OneToOne(mappedBy = "house", cascade = CascadeType.ALL)
    private Person person;
}
