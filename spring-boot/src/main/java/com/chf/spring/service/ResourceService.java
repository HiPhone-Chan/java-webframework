package com.chf.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chf.spring.db.ResourceRepository;
import com.chf.spring.domain.Resource;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public Resource query(Long id) {
        return resourceRepository.findOne(id);
    }
}
