package com.vektorel.eticaretrestapi.restcontroller;

import com.vektorel.eticaretrestapi.repository.entity.Product;
import com.vektorel.eticaretrestapi.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

import static com.vektorel.eticaretrestapi.constants.RestApiUrls.*;

@RestController
@RequestMapping(VERSION+PRODUCT)
@Api(value = "Ürün İşlemleri Servisi")
@Slf4j
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/save")
    @ApiOperation(value = "Ürün kayıt etme işlemi")
    public ResponseEntity<Void> save(String ad, double fiyat, int miktar, MultipartFile resim){
        try {
            String filename = UUID.randomUUID().toString();
            File file = new File("C:\\inetpub\\wwwroot\\img\\"+filename+".png");
            resim.transferTo(file);
            productService.save(Product.builder()
                            .ad(ad)
                            .fiyat(fiyat)
                            .miktar(miktar)
                            .onecikanresim("http://localhost/img/"+filename+".png")
                    .build());
        }catch (Exception exception){
            System.out.println("ProductController Hataaaaaa oldu...: "+ exception.toString());

        }

        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    @ApiOperation(value = "Ürün Listesi")
    public ResponseEntity<List<Product>> urunListesi(){
        return ResponseEntity.ok(productService.findAll());
    }


}
