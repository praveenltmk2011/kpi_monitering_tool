package com.snipecrm.kpi.crud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.snipecrm.kpi.crud.constants.AppConstants;
import com.snipecrm.kpi.crud.model.Contact;
import com.snipecrm.kpi.crud.properties.ApplicationProperties;
import com.snipecrm.kpi.crud.service.ContactService;

@RestController
public class ContactRestController {

	@Autowired
	private ContactService contactService;
	
	@Autowired
	private ApplicationProperties appProps;
	
	
	@PostMapping(value="/saveContact", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addContact(@RequestBody Contact contact){
		
		Map<String, String> messages = appProps.getMessages();
		boolean savedContact = contactService.saveContact(contact);
		if(savedContact)
			return new ResponseEntity<String>(messages.get(AppConstants.CONTACT_SAVE_SUCC), HttpStatus.CREATED);
		else
			return new ResponseEntity<String>(messages.get(AppConstants.CONTACT_SAVE_FAIL), HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@GetMapping(value = "/getContact/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Contact> getContact(@PathVariable("id") Integer contactId) {
		Contact contact = contactService.getContactById(contactId);
		if(contact != null)
			return new ResponseEntity<Contact>(contact, HttpStatus.OK);
		else
			return new ResponseEntity<Contact>(null);
	}
	
	
	
	
	@GetMapping(value = "/getContacts", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Contact>> getContacts(){
		List<Contact> allContacts = contactService.getAllContacts();
		if(allContacts != null)
			return new ResponseEntity<List<Contact>>(allContacts, HttpStatus.OK);
		else
			return new ResponseEntity<List<Contact>>(null);
	}
	
	
	@PutMapping(value = "/updateContact", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateContact(@RequestBody Contact contact){
		
		Map<String, String> messages = appProps.getMessages();
		boolean updated = contactService.saveContact(contact);
		if(updated)
			return new ResponseEntity<String>(messages.get(AppConstants.CONTACT_UPDATE_SUCC), HttpStatus.CREATED);
		else
			return new ResponseEntity<String>(messages.get(AppConstants.CONTACT_UPDATE_FAIL), HttpStatus.BAD_REQUEST);
	}
	
	
	
	
	@DeleteMapping(value = "/deleteContact/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteContact(@PathVariable("id") Integer contactId){
		
		Map<String, String> messages = appProps.getMessages();
		boolean contactById = contactService.deleteContactById(contactId);
		if(contactById)
			return new ResponseEntity<String>(messages.get(AppConstants.CONTACT_DELETE_SUCC), HttpStatus.OK);
		else
			return new ResponseEntity<String>(messages.get(AppConstants.CONTACT_DELETE_FAIL), HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	
	
	
	
}
