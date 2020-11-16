package io.hackages.learning.dao;

import io.hackages.learning.model.Client;
import io.hackages.learning.model.OrderDetails;
import io.hackages.learning.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class OrderDetailsDao {
    
    public Integer saveOrderdetails(OrderDetails orderDetails) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the product object
            Integer id = (Integer) session.save(orderDetails);
            // commit transaction
            transaction.commit();

            return id;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return null;
    }

    public List < OrderDetails > getOrderDetails() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from OrderDetails", OrderDetails.class).list();
        }
    }
}
