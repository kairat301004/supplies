package org.example.supplies.controller;

import lombok.RequiredArgsConstructor;
import org.example.supplies.dto.report.DeliveryReport;
import org.example.supplies.service.DeliveryReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class DeliveryReportController {

    private final DeliveryReportService reportService;

    @GetMapping("/delivery/{id}")
    public DeliveryReport getReport(@PathVariable Long id) {
        return reportService.getReport(id);
    }
}