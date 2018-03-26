/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.copycenter.tools;

import com.mycompany.copycenter.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author max19
 */
public class QueryExecuter {
    
    public static List executeGetterHQLQuery(String hql) {
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException he) {
            he.printStackTrace();
            return null;
        }
    }
    
    public static List executeGetterSQLQuery(String sql) {
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createSQLQuery(sql);
            List resultList = q.list();
            session.getTransaction().commit();
            return resultList;
        } catch (HibernateException he) {
            he.printStackTrace();
            return null;
        }
    }
    
    public static void executeHQLQuery(String hql) {
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createQuery(hql);
            q.executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
    
    public static void executeSQLQuery(String sql) {
        try {
            Session session = NewHibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query q = session.createSQLQuery(sql);
            q.executeUpdate();
            session.getTransaction().commit();
        } catch (HibernateException he) {
            he.printStackTrace();
        }
    }
    
}