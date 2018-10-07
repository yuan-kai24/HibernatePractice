package com.myxq.test;

import com.myxq.domain.Customer;
import com.myxq.uitile.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.List;

/**
 * Created by Tianhao on 2018/10/6.
 */
public class test {

    @Test
    public void test1() {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();//事务
        Customer customer = new Customer();
        customer.setCust_name("hh");
        customer.setCust_level("3");
        customer.setCust_industry("123");
        customer.setCust_phone("123456");
        customer.setCust_mobile("654321");
        customer.setCust_source("哈哈哈！");
        session.save(customer);
        transaction.commit();
        session.close();
    }

    @Test
    public void test2()
    {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();//事务
//        Customer customer = session.get(Customer.class, 1L);
//        customer.setCust_name("袁凯");
//        session.saveOrUpdate(customer);
        Query from_customer_ = session.createQuery("from Customer ");
        List <Customer> list = from_customer_.list();
        for(Customer c : list)
        {
            System.out.println(c);
        }
        transaction.commit();
        session.close();

    }

}

