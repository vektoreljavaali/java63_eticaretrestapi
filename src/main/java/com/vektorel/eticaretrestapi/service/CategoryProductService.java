package com.vektorel.eticaretrestapi.service;

import com.vektorel.eticaretrestapi.repository.ICategoryProductRepository;
import com.vektorel.eticaretrestapi.repository.IProductRepository;
import com.vektorel.eticaretrestapi.repository.entity.CategoryProduct;
import com.vektorel.eticaretrestapi.repository.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryProductService {

    @Autowired
    ICategoryProductRepository repository;

    @Autowired
    IProductRepository productRepository;

    public void save(CategoryProduct item){
        repository.save(item);
    }

    public List<Product> findByCategoryId(long categoryid){
        List<Product> list = new ArrayList<>();
        for (CategoryProduct item:repository.findByCategoryid(categoryid)  ) {
            list.add(
                    productRepository.getOne(item.getProductid())
            );
        }
        return list;
    }
}
