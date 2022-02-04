package com.vektorel.eticaretrestapi.repository;

import com.vektorel.eticaretrestapi.repository.entity.ProductImages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductImagesRepository extends JpaRepository<ProductImages,Long> {

    List<ProductImages> findByUrunid(long urunid);
}
