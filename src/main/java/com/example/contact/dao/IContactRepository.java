package com.example.contact.dao;

import com.example.contact.entities.Contact;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IContactRepository extends JpaRepository<Contact, Long> {

    @Query ("select c from Contact c where c.nom like :x")

    public Page<Contact> chercher(@Param("x") String mc, Pageable pageable);
}
