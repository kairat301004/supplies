package org.example.supplies.dto.report;

import lombok.Data;

@Data
public class DeliveryReportItem {
    private String productName;
    private Double weight;
    private Double price;
}