package com.tona.backendninja.service;

import com.tona.backendninja.entity.Contact;
import com.tona.backendninja.model.ContactModel;

import java.util.List;

/**
 * @author tona created on 16/03/2018 for backendninja.
 */
public interface ContactService {
    ContactModel add(ContactModel contactModel);
    List<ContactModel> listAllContacts();
    Contact findContactById(int id);
    void removeContact(int id);

}
