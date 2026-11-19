package org.springtech.vehicleservicemanagement.DTOs;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VehicleServiceRequest (
        BigDecimal cost,
        String location,
        LocalDate date
) {
}
