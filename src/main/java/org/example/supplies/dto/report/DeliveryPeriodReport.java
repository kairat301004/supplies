package org.example.supplies.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
public class DeliveryPeriodReport {
    private LocalDate startDate;
    private LocalDate endDate;
    private List<SupplierDeliveryReport> suppliers;
}