package com.bitspilani.restaurant.repository;

import com.bitspilani.restaurant.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice,Integer> {
}
