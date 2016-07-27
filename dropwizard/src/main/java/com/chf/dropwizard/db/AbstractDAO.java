package com.chf.dropwizard.db;

public abstract class AbstractDAO<E>
        extends io.dropwizard.hibernate.AbstractDAO<E> {

    public AbstractDAO() {
        super(DbUtil.getSessionFactory());
    }

}
