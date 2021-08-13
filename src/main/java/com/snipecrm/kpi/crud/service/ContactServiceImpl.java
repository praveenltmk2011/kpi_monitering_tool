package com.snipecrm.kpi.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snipecrm.kpi.crud.model.Contact;
import com.snipecrm.kpi.crud.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	@Override
	public boolean saveContact(Contact contact) {
		Contact savedEntity = contactRepo.save(contact);
		if(savedEntity != null)
			return true;
		return false;
	}

	@Override
	public Contact getContactById(Integer ContactId) {
		Optional<Contact> contact = contactRepo.findById(ContactId);
		if(contact.isPresent()) {
			return contact.get();
		}
		return null;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> contacts = contactRepo.findAll();
		if(contacts != null)
			return contacts;
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		try {
			contactRepo.deleteById(contactId);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
