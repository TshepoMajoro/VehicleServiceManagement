package org.springtech.vehicleservicemanagement.Repository;

import org.springframework.stereotype.Repository;
import org.springtech.vehicleservicemanagement.Entities.VehicleServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface VehicleServiceRepository extends JpaRepository<VehicleServiceEntity, Long> {
}
