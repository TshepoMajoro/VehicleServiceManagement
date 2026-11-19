package org.springtech.vehicleservicemanagement.DTOs;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VehicleServiceResponse (
        long id,
        BigDecimal cost,
        String location,
        LocalDate date
) {
}
