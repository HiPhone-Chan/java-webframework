package com.chf.dropwizard.db;

import java.io.Serializable;

import javax.inject.Singleton;

import com.chf.dropwizard.domain.Resource;

@Singleton
public class ResourceDAO extends AbstractDAO<Resource> {

    @Override
    public Resource get(Serializable id) {
        return super.get(id);
    }

}
