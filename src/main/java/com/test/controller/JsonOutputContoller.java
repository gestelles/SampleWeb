package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.model.Contact;
import com.test.service.ContactService;
 
@Controller
@RequestMapping(value = "/json")
public class JsonOutputContoller {
 
    @Autowired
    private ContactService contactService;
	
    /**
     * http://bharatonjava.wordpress.com/2013/05/05/spring-3-mvc-and-json-response/
     * 
     * @return
     */
    @RequestMapping(value = "/contact/list", method = RequestMethod.GET)
    public @ResponseBody List<Contact> generateJsonResponse(){
        List<Contact> contactList = contactService.listContact();
        return contactList;
    }

    @RequestMapping("/contact/{id}")
    public @ResponseBody Contact generateJsonResponse(@PathVariable("id") int id){
        Contact e = contactService.getContact(id);
        return e;
    }
    
}
