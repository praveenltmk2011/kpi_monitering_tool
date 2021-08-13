package com.snipecrm.kpi.crud.service;

import java.util.List;

import com.snipecrm.kpi.crud.model.Contact;

public interface ContactService {

	public boolean saveContact(Contact contact);
	
	public Contact getContactById(Integer ContactId);
	
	public List<Contact> getAllContacts();
	
	public boolean deleteContactById(Integer contactId);
}
