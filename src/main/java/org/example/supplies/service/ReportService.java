package org.example.supplies.service;

import lombok.RequiredArgsConstructor;
import org.example.supplies.dto.report.DeliveryPeriodReport;
import org.example.supplies.dto.report.DeliveryProductReport;
import org.example.supplies.dto.report.SupplierDeliveryReport;
import org.example.supplies.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@RequiredArgsConstructor
public class ReportService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryPeriodReport getDeliveryReport(LocalDate start, LocalDate end) {

        List<Object[]> rows = deliveryRepository.getReport(start, end);

        Map<String, SupplierDeliveryReport> suppliers = new LinkedHashMap<>();

        for (Object[] row : rows) {
            String supplierName = (String) row[0];
            String productName = (String) row[1];
            double weight = ((Number) row[2]).doubleValue();
            double cost = ((Number) row[3]).doubleValue();

            suppliers.putIfAbsent(
                    supplierName,
                    new SupplierDeliveryReport(
                            supplierName,
                            0,
                            0,
                            new ArrayList<>()
                    )
            );

            SupplierDeliveryReport report = suppliers.get(supplierName);

            report.getProducts().add(
                    new DeliveryProductReport(productName, weight, cost)
            );

            report.setTotalWeight(report.getTotalWeight() + weight);
            report.setTotalCost(report.getTotalCost() + cost);
        }

        return new DeliveryPeriodReport(start, end, new ArrayList<>(suppliers.values()));
    }
}