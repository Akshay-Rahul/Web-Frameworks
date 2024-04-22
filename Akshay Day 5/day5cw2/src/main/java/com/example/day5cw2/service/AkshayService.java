package com.example.day5cw2.service;

import org.springframework.stereotype.Service;

import com.example.day5cw2.model.AkshayModel;
import com.example.day5cw2.repository.AkshayRepo;

@Service
public class AkshayService {
    public AkshayRepo employeeRepo;
    public AkshayService(AkshayRepo employeeRepo)
    {
        this.employeeRepo = employeeRepo;
    }
    public boolean saveEmployee(AkshayModel employee)
    {
        try
        {
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,AkshayModel employee)
    {
        if(this.getEmployeeById(id)==null)
        {
            return false;
        }
        try{
            employeeRepo.save(employee);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteEmployee(int id)
    {
        if(this.getEmployeeById(id) == null)
        {
            return false;
        }
        employeeRepo.deleteById(id);
        return true;
    }
    public AkshayModel getEmployeeById(int id)
    {
        return employeeRepo.findById(id).orElse(null);
    }
}
