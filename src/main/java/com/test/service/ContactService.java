package com.test.service;

import java.util.List;

import com.test.model.Contact;
 
public interface ContactService {
     
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
}