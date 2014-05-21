package com.test.service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.ContactDAO;
import com.test.model.Contact;
import com.test.service.ContactService;

import static org.junit.Assert.*;

/**
 * http://giannisapi.wordpress.com/2011/09/30/spring-3-testing-with-junit-4-using-contextconfiguration-and-abstracttransactionaljunit4springcontexttests/
 * @author gestelles
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class ContactServiceTest {

    @Autowired
    protected ContactDAO contact;
    
    @Autowired
    protected ContactService contactService;
        
    @Test
    @Timed(millis=1000)
    @Transactional
    public void sampleTest(){
    	
    	int size1 = contactService.listContact().size();
        //System.out.println("Number of rows is: " + contactService.listContact().size());
        //System.out.println("Creating a new contact");
        
        Contact cont = new Contact();
        cont.setEmail("giannis@gmail.com");
        cont.setLastname("ntantis");
        cont.setFirstname("ioannis");
        cont.setTelephone("00306985587996");
        System.out.println("Before saving contact");
        contactService.addContact(cont);
        
        int contactId = cont.getId();
        assertTrue(contactId>0);
        
        int size2 = contactService.listContact().size();
        assertEquals(size2, size1+1);
        
        //System.out.println("After saving contact. Id if contact is: " + cont.getId());
        //System.out.println("Number of rows now is: " + contactService.listContact().size());
    }
	
}
