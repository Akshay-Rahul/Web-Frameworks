package com.example.day5cw1.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.day5cw1.model.AkshayProduct;
import com.example.day5cw1.service.AkshayService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
public class AkshayController {
    public AkshayService productService;
    public AkshayController(AkshayService productService)
    {
        this.productService = productService;
    }
    @PostMapping("/api/product")
    public ResponseEntity<AkshayProduct> postMethodName(@RequestBody AkshayProduct product) {
        if(productService.saveProduct(product) == true)
        {
            return new ResponseEntity<>(product,HttpStatus.CREATED);
        }
        
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/api/product/{productId}")
    public ResponseEntity<AkshayProduct> putMethodName(@PathVariable("productId") int id, @RequestBody AkshayProduct product) {
        if(productService.updateDetails(id,product) == true)
        {
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("api/product/{productId}")
    public ResponseEntity<AkshayProduct> delete(@PathVariable("productId") int id,@RequestBody AkshayProduct product)
    {
        if(productService.deleteProduct(id) == true)
        {
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }
}
