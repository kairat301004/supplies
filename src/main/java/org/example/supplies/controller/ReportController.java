package org.example.supplies.controller;

import lombok.RequiredArgsConstructor;
import org.example.supplies.dto.report.DeliveryPeriodReport;
import org.example.supplies.service.ReportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/reports")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("/deliveries")
    public DeliveryPeriodReport getReport(
            @RequestParam LocalDate start,
            @RequestParam LocalDate end
    ) {
        return reportService.getDeliveryReport(start, end);
    }
}