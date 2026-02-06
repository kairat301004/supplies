package org.example.supplies.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class DeliveryRequest {
    private Long supplierId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    private List<DeliveryItemRequest> items;

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public List<DeliveryItemRequest> getItems() {
        return items;
    }

    public void setItems(List<DeliveryItemRequest> items) {
        this.items = items;
    }
}