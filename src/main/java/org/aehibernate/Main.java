package org.aehibernate;


import org.aehibernate.dao.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
    }
}