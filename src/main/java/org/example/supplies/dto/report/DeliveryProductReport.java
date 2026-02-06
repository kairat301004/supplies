package org.example.supplies.dto.report;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryProductReport {
    private String productName;
    private double totalWeight;
    private double totalCost;
}