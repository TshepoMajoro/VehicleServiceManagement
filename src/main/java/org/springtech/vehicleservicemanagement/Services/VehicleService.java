package org.springtech.vehicleservicemanagement.Services;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springtech.vehicleservicemanagement.DTOs.VehicleServiceResponse;
import org.springtech.vehicleservicemanagement.Repository.VehicleServiceRepository;

import java.util.List;

@Service
public class VehicleService {
    private VehicleServiceRepository vehicleServiceRepository;

    public VehicleService(VehicleServiceRepository vehicleServiceRepository) {
        this.vehicleServiceRepository = vehicleServiceRepository;
    }

    @Transactional
    public List<VehicleServiceResponse> getAllBookedServices(){
        return vehicleServiceRepository.findAll().stream().map(service -> mapToResponse(service)).toList();
    }
}
