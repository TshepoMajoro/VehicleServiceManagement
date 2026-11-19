package org.springtech.vehicleservicemanagement.Repository;

import org.springtech.vehicleservicemanagement.Entities.VehicleServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleServiceRepository extends JpaRepository<VehicleServiceEntity, Long> {
}
