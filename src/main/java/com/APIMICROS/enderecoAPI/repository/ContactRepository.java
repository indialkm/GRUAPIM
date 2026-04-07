
package com.APIMICROS.enderecoAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.APIMICROS.enderecoAPI.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    List<Contact> findByNomeContainingIgnoreCase(String nome);
}
