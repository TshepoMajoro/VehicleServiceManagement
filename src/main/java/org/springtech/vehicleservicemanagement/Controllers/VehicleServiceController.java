package org.springtech.vehicleservicemanagement.Controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springtech.vehicleservicemanagement.DTOs.VehicleServiceRequest;
import org.springtech.vehicleservicemanagement.DTOs.VehicleServiceResponse;
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
    public ResponseEntity<VehicleServiceResponse> getById(@PathVariable long id) throws ResourceNotFoundException {
        VehicleServiceResponse response = vehicleService.getServiceById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<VehicleServiceResponse> createService(@Valid @RequestBody VehicleServiceRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleService.addService(request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable long id) throws ResourceNotFoundException {
        vehicleService.deleteServiceById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateService(@PathVariable long id, @RequestBody VehicleServiceRequest request) throws ResourceNotFoundException {
        vehicleService.updateService(id, request);
        return ResponseEntity.noContent().build();
    }
}
