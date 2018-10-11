package com.myxq.test;

import com.myxq.domain.Customer;
import com.myxq.domain.Linkman;
import com.myxq.uitile.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Tianhao on 2018/10/11.
 */
public class test3 {
    @Test
    public void test(){
        Session currentSession = HibernateUtil.getCurrentSession();
        Transaction transaction = currentSession.beginTransaction();

        Customer customer1 = new Customer();
        customer1.setCust_name("one");

        Customer customer2 = new Customer();
        customer2.setCust_name("two");

        Customer customer3 = new Customer();
        customer3.setCust_name("tree");

        Linkman linkman1 = new Linkman();

        transaction.commit();
        currentSession.close();
    }
}
