package com.example.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springapp.model.Person;
import com.example.springapp.repository.PersonRepo;

@Service
public class AkshayPersonService {
    @Autowired
    private PersonRepo rep;

    public boolean post(Person person)
    {
        try
        {
            rep.save(person);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public List<Person> getAll()
    {
        return rep.findAll();
    }

    public List<Person> getbyAge(int age)
    {
        return rep.findByAge(age);
    }
    
}
