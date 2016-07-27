package com.chf.dropwizard.service;

import javax.annotation.ManagedBean;

@ManagedBean
public class ResourceService {

//    @Inject
//    private ResourceDAO resourceDAO;
//
//    public Resource query(Long id) {
//        return resourceDAO.get(id);
//    }

    public String findAll() {
        return "get";
    }

}
