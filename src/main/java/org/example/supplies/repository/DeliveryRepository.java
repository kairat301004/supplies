package org.example.supplies.repository;

import org.example.supplies.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    @Query("""
    SELECT d.id AS deliveryId,
           d.date AS deliveryDate,
           s.name AS supplierName,
           p.name AS productName,
           i.weight AS weight,
           i.price AS price
    FROM Delivery d
    JOIN d.supplier s
    JOIN d.items i
    JOIN i.product p
    WHERE d.id = :deliveryId
""")
    List<Object[]> getDeliveryReportRaw(@Param("deliveryId") Long deliveryId);


    @Query("""
    SELECT d.supplier.name,
           di.product.name,
           SUM(di.weight),
           SUM(di.weight * di.price)
    FROM Delivery d
    JOIN d.items di
    WHERE d.date BETWEEN :start AND :end
    GROUP BY d.supplier.name, di.product.name
    ORDER BY d.supplier.name, di.product.name
    """)
    List<Object[]> getReport(@Param("start") LocalDate start, @Param("end") LocalDate end);

}