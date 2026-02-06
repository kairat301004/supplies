package org.example.supplies.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SupplierDeliveryReport {
    private String supplierName;
    private double totalWeight;
    private double totalCost;
    private List<DeliveryProductReport> products;
}
