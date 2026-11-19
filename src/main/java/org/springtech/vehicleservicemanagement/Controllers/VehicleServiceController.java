package org.springtech.vehicleservicemanagement.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springtech.vehicleservicemanagement.DTOs.VehicleServiceResponse;
import org.springtech.vehicleservicemanagement.Entities.VehicleServiceEntity;
import org.springtech.vehicleservicemanagement.Exceptions.ResourceNotFoundException;
import org.springtech.vehicleservicemanagement.Services.VehicleService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/service")
public class VehicleServiceController {
    private final VehicleService vehicleService;

    public VehicleServiceController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }


    @GetMapping
    public ResponseEntity<List<VehicleServiceResponse>> getAll(){
        List<VehicleServiceResponse> response = vehicleService.getAllBookedServices();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleServiceResponse> getById(long id) throws ResourceNotFoundException {
        VehicleServiceResponse response = vehicleService.getServiceById(id);
        return ResponseEntity.ok(response);
    }
}
