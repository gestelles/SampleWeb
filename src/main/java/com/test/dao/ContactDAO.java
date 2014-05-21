package com.test.dao;

import java.util.List;

import com.test.model.Contact;

 public interface ContactDAO {
     
	public Contact get(int id);
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
}