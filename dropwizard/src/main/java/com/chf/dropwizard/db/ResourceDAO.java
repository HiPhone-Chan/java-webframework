package com.chf.dropwizard.db;

import java.io.Serializable;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.chf.dropwizard.domain.Resource;

import io.dropwizard.hibernate.AbstractDAO;

@Repository
public class ResourceDAO extends AbstractDAO<Resource> {

    public ResourceDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Resource get(Serializable id) {
        return super.get(id);
    }

}
