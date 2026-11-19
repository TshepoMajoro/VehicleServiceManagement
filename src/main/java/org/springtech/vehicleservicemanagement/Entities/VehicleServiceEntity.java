package org.springtech.vehicleservicemanagement.Entities;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Services")
public class VehicleServiceEntity {
    @Id
    @GeneratedValue(strategy = GENERATEDALWAYS.IDENTITY)
    private long id;
    @Column
    private String cost;
    @Column
    private String location;
    @Column
    private LocalDate date;
}
