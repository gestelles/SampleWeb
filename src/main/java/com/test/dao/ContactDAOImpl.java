package com.test.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.model.Contact;
 
@Repository
public class ContactDAOImpl implements ContactDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    public void addContact(Contact contact) {
        sessionFactory.getCurrentSession().save(contact);
    }
 
    @SuppressWarnings("unchecked")
	public List<Contact> listContact() {
        return sessionFactory.getCurrentSession().createQuery("from Contact")
                .list();
    }
 
    public void removeContact(Integer id) {
        Contact contact = (Contact) sessionFactory.getCurrentSession().load(
                Contact.class, id);
        if (null != contact) {
            sessionFactory.getCurrentSession().delete(contact);
        }
 
    }
}