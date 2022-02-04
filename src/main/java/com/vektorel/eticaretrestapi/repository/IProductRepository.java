package com.vektorel.eticaretrestapi.repository;

import com.vektorel.eticaretrestapi.repository.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
}
