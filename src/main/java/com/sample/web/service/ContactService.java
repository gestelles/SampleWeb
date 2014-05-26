package com.sample.web.service;

import java.util.List;

import com.sample.web.model.Contact;
 
public interface ContactService {
     
    public Contact getContact(int id);
    public void addContact(Contact contact);
    public List<Contact> listContact();
    public void removeContact(Integer id);
}