package org.springtech.vehicleservicemanagement.DTOs;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

public record VehicleServiceRequest (
        @NotNull(message = "cost is a required field.")
        BigDecimal cost,
        @NotNull(message = "location is a required field.")
        String location,
        @NotNull(message = "date is a required field.")
        @FutureOrPresent
        LocalDate date
) {
}
