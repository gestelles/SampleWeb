package com.test.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.model.Contact;
import com.test.service.ContactService;
 
@Controller
@RequestMapping("/")
public class ContactController {
 
	//get log4j handler
	private static final Logger logger = Logger.getLogger(ContactController.class);
	
    @Autowired
    private ContactService contactService;
 
    @RequestMapping("/")
    public String listContacts(Map<String, Object> map) {
 
        map.put("contact", new Contact());
        map.put("contactList", contactService.listContact());
 
        logger.debug("Pintado listado...");
        
        return "contact";
    }
 
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("contact")
    Contact contact, BindingResult result) {
 
        contactService.addContact(contact);
 
        return "redirect:/";
    }
 
    @RequestMapping("/delete/{contactId}")
    public String deleteContact(@PathVariable("contactId")
    Integer contactId) {
 
        contactService.removeContact(contactId);
 
        return "redirect:/";
    }
    

    
}