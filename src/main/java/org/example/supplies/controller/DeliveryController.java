package org.example.supplies.controller;
import lombok.RequiredArgsConstructor;
import org.example.supplies.dto.DeliveryRequest;
import org.example.supplies.model.Delivery;
import org.example.supplies.service.DeliveryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/deliveries")
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping
    public Delivery createDelivery(@RequestBody DeliveryRequest request) {
        return deliveryService.createDelivery(request);
    }
}