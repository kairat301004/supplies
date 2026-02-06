package org.example.supplies.dto.report;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class DeliveryReport {
    private Long id;
    private LocalDate date;
    private String supplierName;
    private List<DeliveryReportItem> items;
}