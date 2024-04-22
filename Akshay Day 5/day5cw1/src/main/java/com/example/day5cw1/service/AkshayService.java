package com.example.day5cw1.service;

import org.springframework.stereotype.Service;

import com.example.day5cw1.model.AkshayProduct;
import com.example.day5cw1.repository.AkshayRepo;

@Service
public class AkshayService {
    public AkshayRepo productRepo;
    public AkshayService(AkshayRepo productRepo)
    {
        this.productRepo = productRepo;
    }
    public boolean saveProduct(AkshayProduct product)
    {
        try
        {
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,AkshayProduct product)
    {
        if(this.getProductById(id)==null)
        {
            return false;
        }
        try{
            productRepo.save(product);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteProduct(int id)
    {
        if(this.getProductById(id) == null)
        {
            return false;
        }
        productRepo.deleteById(id);
        return true;
    }
    public AkshayProduct getProductById(int id)
    {
        return productRepo.findById(id).orElse(null);
    }
}
