package org.example.supplies.service;

import lombok.RequiredArgsConstructor;
import org.example.supplies.dto.report.DeliveryReport;
import org.example.supplies.dto.report.DeliveryReportItem;
import org.example.supplies.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryReportService {

    private final DeliveryRepository deliveryRepository;

    public DeliveryReport getReport(Long deliveryId) {

        List<Object[]> rows = deliveryRepository.getDeliveryReportRaw(deliveryId);

        if (rows.isEmpty()) {
            throw new RuntimeException("Delivery not found");
        }

        DeliveryReport report = new DeliveryReport();
        List<DeliveryReportItem> items = new ArrayList<>();

        for (Object[] r : rows) {
            report.setId((Long) r[0]);
            report.setDate((java.time.LocalDate) r[1]);
            report.setSupplierName((String) r[2]);

            DeliveryReportItem item = new DeliveryReportItem();
            item.setProductName((String) r[3]);
            item.setWeight((Double) r[4]);
            item.setPrice((Double) r[5]);

            items.add(item);
        }

        report.setItems(items);
        return report;
    }
}