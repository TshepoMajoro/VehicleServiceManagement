package org.springtech.vehicleservicemanagement.Services;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import org.springtech.vehicleservicemanagement.DTOs.VehicleServiceRequest;
import org.springtech.vehicleservicemanagement.DTOs.VehicleServiceResponse;
import org.springtech.vehicleservicemanagement.Entities.VehicleServiceEntity;
import org.springtech.vehicleservicemanagement.Exceptions.ResourceNotFoundException;
import org.springtech.vehicleservicemanagement.Repository.VehicleServiceRepository;

import java.util.List;

@Service
public class VehicleService {
    private VehicleServiceRepository vehicleServiceRepository;

    public VehicleService(VehicleServiceRepository vehicleServiceRepository) {
        this.vehicleServiceRepository = vehicleServiceRepository;
    }

    private VehicleServiceResponse mapEntityToResponse(VehicleServiceEntity vehicleService) {
        return new VehicleServiceResponse(
                vehicleService.getId(),
                vehicleService.getCost(),
                vehicleService.getLocation(),
                vehicleService.getDate()
        );
    }

    private VehicleServiceEntity mapRequestToEntity(VehicleServiceRequest request){
        VehicleServiceEntity entity = new VehicleServiceEntity();

        entity.setCost(request.cost());
        entity.setLocation(request.location());
        entity.setDate(request.date());

        return entity;
    }

    @Transactional
    public List<VehicleServiceResponse> getAllBookedServices(){
        return vehicleServiceRepository.findAll().stream().map(service -> mapEntityToResponse(service)).toList();
    }

    @Transactional
    public VehicleServiceResponse getServiceById(long id) throws ResourceNotFoundException {
        if (!vehicleServiceRepository.existsById(id)){
            throw new ResourceNotFoundException("resource with id "+id+" not found.");
        }
        VehicleServiceEntity service = vehicleServiceRepository.findById(id).get();
        return mapEntityToResponse(service);
    }

    @Transactional
    public void addService(VehicleServiceRequest request){
        VehicleServiceEntity entity = mapRequestToEntity(request);
        vehicleServiceRepository.save(entity);
    }

}
