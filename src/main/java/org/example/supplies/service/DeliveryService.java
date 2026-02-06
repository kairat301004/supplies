package org.example.supplies.service;

import lombok.RequiredArgsConstructor;
import org.example.supplies.dto.DeliveryItemRequest;
import org.example.supplies.dto.DeliveryRequest;
import org.example.supplies.model.Delivery;
import org.example.supplies.model.DeliveryItem;
import org.example.supplies.model.Product;
import org.example.supplies.model.Supplier;
import org.example.supplies.repository.DeliveryRepository;
import org.example.supplies.repository.ProductRepository;
import org.example.supplies.repository.SupplierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final SupplierRepository supplierRepository;
    private final ProductRepository productRepository;
    private final DeliveryRepository deliveryRepository;

    public Delivery createDelivery(DeliveryRequest request) {

        Supplier supplier = supplierRepository.findById(request.getSupplierId())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        Delivery delivery = new Delivery();
        delivery.setSupplier(supplier);
        delivery.setDate(request.getDate());

        List<DeliveryItem> items = request.getItems().stream()
                .map(itemRequest -> mapItem(itemRequest, delivery))
                .toList();

        delivery.setItems(items);
        return deliveryRepository.save(delivery);
    }

    private DeliveryItem mapItem(DeliveryItemRequest itemRequest, Delivery delivery) {

        Product product = productRepository.findById(itemRequest.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        DeliveryItem item = new DeliveryItem();
        item.setDelivery(delivery);
        item.setProduct(product);
        item.setWeight(itemRequest.getWeight());
        item.setPrice(itemRequest.getPrice());

        return item;
    }
}
