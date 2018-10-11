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
        customer1.setCust_name("customer1");

        Customer customer2 = new Customer();
        customer2.setCust_name("customer2");

        Customer customer3 = new Customer();
        customer3.setCust_name("customer3");

        Linkman linkman11 = new Linkman();
        linkman11.setLink_name("linkman11");
        Linkman linkman12 = new Linkman();
        linkman12.setLink_name("linkman12");
        Linkman linkman13 = new Linkman();
        linkman13.setLink_name("linkman13");

        //配置关系
        customer1.getLinkmens().add(linkman11);
        customer1.getLinkmens().add(linkman12);
        customer2.getLinkmens().add(linkman13);

        linkman11.setCustomer(customer1);
        linkman12.setCustomer(customer1);
        linkman13.setCustomer(customer2);

        currentSession.save(customer1);
        currentSession.save(customer2);
        currentSession.save(customer3);

        currentSession.save(linkman11);
        currentSession.save(linkman12);
        currentSession.save(linkman13);


        transaction.commit();
    }
}
