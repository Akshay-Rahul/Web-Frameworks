package com.example.day5cw3.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.day5cw3.model.AkshayLanguage;
import com.example.day5cw3.repository.AkshayLanguageRepo;

@Service
public class AkshayLanguageService {
    private AkshayLanguageRepo languageRepo;
    public AkshayLanguageService(AkshayLanguageRepo languageRepo)
    {
        this.languageRepo=languageRepo;
    }
    public boolean saveLanguage(AkshayLanguage language)
    {
        try
        {
            languageRepo.save(language);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<AkshayLanguage> getLanguages()
    {
        return languageRepo.findAll();
    }
    public boolean updateLanguage(int id,AkshayLanguage language)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        try{
            languageRepo.save(language);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteLanguage(int id)
    {
        if(getLanguageById(id)==null)
        {
            return false;
        }
        languageRepo.deleteById(id);
        return true;
        
    }
    public AkshayLanguage getLanguageById(int id)
    {
        return languageRepo.findById(id).orElse(null);
    }

}
