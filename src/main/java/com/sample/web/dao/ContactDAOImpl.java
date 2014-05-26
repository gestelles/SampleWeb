package com.sample.web.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sample.web.model.Contact;
 
@Repository
public class ContactDAOImpl implements ContactDAO {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    @Override
    public Contact get(int id) {
    	return (Contact)sessionFactory.getCurrentSession().get(Contact.class, id);
    }
    
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