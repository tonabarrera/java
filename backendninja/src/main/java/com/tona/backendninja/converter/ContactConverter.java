package com.tona.backendninja.converter;

import com.tona.backendninja.entity.Contact;
import com.tona.backendninja.model.ContactModel;
import org.springframework.stereotype.Component;

/**
 * @author tona created on 16/03/2018 for backendninja.
 */
@Component("contactConverter")
public class ContactConverter {
    public Contact modelToEntity(ContactModel contactModel) {
        Contact contact = new Contact();
        contact.setId(contactModel.getId());
        contact.setCity(contactModel.getCity());
        contact.setFirstname(contactModel.getFirstname());
        contact.setLastname(contactModel.getLastname());
        contact.setTelephone(contactModel.getTelephone());
        return contact;
    }

    public ContactModel entityToModel(Contact contact) {
        ContactModel contactModel = new ContactModel();
        contactModel.setId(contact.getId());
        contactModel.setCity(contact.getCity());
        contactModel.setFirstname(contact.getFirstname());
        contactModel.setLastname(contact.getLastname());
        contactModel.setTelephone(contact.getTelephone());
        return contactModel;
    }
}
