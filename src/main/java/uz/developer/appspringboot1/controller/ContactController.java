package uz.developer.appspringboot1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.developer.appspringboot1.entity.Contact;
import uz.developer.appspringboot1.payload.ReqContact;
import uz.developer.appspringboot1.repository.ContactRepository;
import uz.developer.appspringboot1.service.ContactService;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {

    @Autowired
    ContactService contactService;
    @Autowired
    ContactRepository contactRepository;

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    @ResponseBody
    public boolean addContact(@RequestBody ReqContact reqContact) {
        return contactService.saveContact(reqContact);

    }

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    @ResponseBody
    public String getContactPage() {
        return "ContactPage";
    }

    @RequestMapping(value = "/contact/list", method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> contacts() {
        return contactService.getContacts();
    }

    @RequestMapping(value = "/contact/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Contact getContact(@PathVariable Integer id){
        Optional<Contact> optionalContact = contactRepository.findById(id);
        return optionalContact.orElseGet(Contact::new);
    }

    @RequestMapping(value = "/contact/{id}",method = RequestMethod.PUT)
    @ResponseBody
    public boolean editContact(@PathVariable Integer id, @RequestBody ReqContact reqContact){
        return contactService.editContact(id, reqContact);

    }

    @RequestMapping(value = "/contact/{id}",method = RequestMethod.DELETE)
    @ResponseBody
    public boolean deleteContact(@PathVariable Integer id){
        contactRepository.deleteById(id);
        return true;
    }

}
