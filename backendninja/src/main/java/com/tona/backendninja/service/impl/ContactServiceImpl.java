package com.tona.backendninja.service.impl;

import com.tona.backendninja.converter.ContactConverter;
import com.tona.backendninja.entity.Contact;
import com.tona.backendninja.model.ContactModel;
import com.tona.backendninja.repository.ContactRepository;
import com.tona.backendninja.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tona created on 16/03/2018 for backendninja.
 */
@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService{
    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    @Override
    public ContactModel add(ContactModel contactModel) {
        Contact contact = contactRepository.save(contactConverter.modelToEntity(contactModel));
        return contactConverter.entityToModel(contact);
    }

    @Override
    public List<ContactModel> listAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        List<ContactModel> contactsModel = new ArrayList<>();
        for (Contact contact : contacts) {
            contactsModel.add(contactConverter.entityToModel(contact));
        }

        return contactsModel;
    }

    @Override
    public Contact findContactById(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public void removeContact(int id) {
        Contact contact = findContactById(id);
        if (contact != null)
            contactRepository.delete(contact);
    }

    @Override
    public ContactModel findContactModelById(int id) {
        return contactConverter.entityToModel(findContactById(id));
    }
}
