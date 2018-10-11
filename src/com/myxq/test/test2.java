package com.myxq.test;

import com.myxq.domain.Customer;
import com.myxq.uitile.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

/**
 * Created by Tianhao on 2018/10/9.
 */
public class test2 {

    @Test
    public void test(){
        //线程内的session
        Session session = HibernateUtil.getCurrentSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = session.get(Customer.class, 1L);
        System.out.println(customer);

        Customer customer1 = session.get(Customer.class, 1L);
        System.out.println(customer1.equals(customer));

        transaction.commit();
        session.close();

    }
}
