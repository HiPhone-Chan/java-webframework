package com.chf.dropwizard.db;

import org.hibernate.SessionFactory;

public final class DbUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void setSessionFactory(SessionFactory sessionFactory) {
        DbUtil.sessionFactory = sessionFactory;
    }

}
