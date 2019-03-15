package com.example.contact.controller;


import com.example.contact.dao.IContactRepository;
import com.example.contact.entities.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.QueryParam;
import java.util.List;

@RestController
@RequestMapping("/contact")
@CrossOrigin("*")
public class ContactController  {

    @Autowired
    private IContactRepository iContactRepository;
    @GetMapping("")
    public String homme()
    {
        return "okkkkkkkkk";
    }

@GetMapping("/ById")

public Contact getContactById(@PathVariable  Long id){
             return iContactRepository.getOne(id);
}
    @GetMapping("/all")
    public List<Contact> getALL(){
        return iContactRepository.findAll();

    }



    @PostMapping("/add")

    public Contact addContact(@RequestBody Contact contact){

        return iContactRepository.saveAndFlush(contact);
    }

    @PutMapping("/update")
    public Contact updateContact(@RequestBody Contact contact, @RequestParam Long id){
        contact.setId(id);
        return iContactRepository.saveAndFlush(contact);

    }

    @GetMapping("/chercherContact")

    public Page<Contact> chercher(
            @RequestParam(name = "mc", defaultValue = "") String mc,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size){
        return iContactRepository.chercher("%"+mc+"%", new PageRequest (page,size));
    }
    @DeleteMapping("/delete")

    public String deleteContact(Long id){
        try {
            iContactRepository.deleteById(id);
            return "okkkkk";
        }
       catch(Exception e){
            return "noooooooooooo";
       }
    }

}

