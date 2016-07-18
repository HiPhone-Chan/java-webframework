package com.chf.dropwizard.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.chf.dropwizard.db.ResourceDAO;
import com.chf.dropwizard.domain.Resource;

@Service
public class ResourceService {

    @Inject
    private ResourceDAO resourceDAO;

    public Resource query(Long id) {
        return resourceDAO.get(id);
    }
    
    public String findAll(){
        return "get";
    }

}
