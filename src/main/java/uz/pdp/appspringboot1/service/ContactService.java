package uz.pdp.appspringboot1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appspringboot1.entity.Contact;
import uz.pdp.appspringboot1.payload.ReqContact;
import uz.pdp.appspringboot1.repository.ContactRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public boolean saveContact(ReqContact reqContact) {
        boolean existsByNumber = contactRepository.existsByNumber(reqContact.getNumber());
        if (!existsByNumber) {
            Contact contact = new Contact();
            contact.setFirstName(reqContact.getFirstName());
            contact.setLastName(reqContact.getLastName());
            contact.setMiddleName(reqContact.getMiddleName());
            contact.setNumber(reqContact.getNumber());
            contactRepository.save(contact);
            return true;
        }

        return false;

    }

    public List<Contact> getContacts() {
        List<Contact> all = contactRepository.findAll();
        return all;
    }

    public boolean editContact(Integer id, ReqContact reqContact) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()){
            boolean exists = contactRepository.existsByNumberAndIdNot(reqContact.getNumber(), id);
            if (!exists){
                Contact contact = optionalContact.get();
                contact.setFirstName(reqContact.getFirstName());
                contact.setLastName(reqContact.getLastName());
                contact.setMiddleName(reqContact.getMiddleName());
                contact.setMiddleName(reqContact.getNumber());
                contactRepository.save(contact);
                return true;
            }
        }
        return false;
    }
}
