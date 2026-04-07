package com.APIMICROS.enderecoAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.*;

import com.APIMICROS.enderecoAPI.model.Address;
import com.APIMICROS.enderecoAPI.model.Contact;
import com.APIMICROS.enderecoAPI.repository.AddressRepository;
import com.APIMICROS.enderecoAPI.repository.ContactRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {

	  /**
     * @Autowired permite que o Spring "injete" automaticamente
     * uma instância de ContactRepository aqui, 
     * sem que precisemos criar manualmente.
     */
	@Autowired
    private ContactRepository contactRepository;
	private AddressRepository addressRepository;
	
	@GetMapping("/{id}/addresses")
	public ResponseEntity<List<Address>> getAddressesByContact(@PathVariable Long id) {
	   
	    List<Address> addresses = addressRepository.findByContactId(id);
	    return ResponseEntity.ok(addresses);
	}

    @GetMapping("/search")
    public List<Contact> searchByName(@RequestParam String name) {
        return contactRepository.findByNomeContainingIgnoreCase(name);

    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<Contact> updatePartial(@PathVariable Long id, @RequestBody Contact updates) {
        return contactRepository.findById(id).map(existingContact -> {
            
            if (updates.getNome() != null) {
                existingContact.setNome(updates.getNome());
            }
            
            if (updates.getTelefone() != null) {
                existingContact.setTelefone(updates.getTelefone());
            }
            
            if (updates.getEmail() != null) {
                existingContact.setEmail(updates.getEmail());
            }

            Contact updated = contactRepository.save(existingContact);
            return ResponseEntity.ok(updated);
            
        }).orElse(ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    /**
     * Método para obter um contato específico pelo seu ID.
     * 
     * @PathVariable "amarra" a variável {id} da URL 
     * ao parâmetro do método.
     * Exemplo de acesso: GET /api/contacts/1
     */
    @GetMapping("/{id}")
    public Contact getContactById(@PathVariable Long id) {
        // findById retorna um Optional, então usamos orElseThrow
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado: " + id));
    }

    /**
     * Método para criar um novo contato.
     * 
     * @PostMapping indica que este método responde a chamadas HTTP POST.
     * @RequestBody indica que o objeto Contact será preenchido 
     * com os dados JSON enviados no corpo da requisição.
     */
    @PostMapping
    public ResponseEntity<Contact> create(@Valid @RequestBody Contact contact) {
        Contact saved = contactRepository.save(contact);
        return ResponseEntity.status(201).body(saved);
    }

    /**
     * Método para atualizar um contato existente.
     * 
     * @PutMapping indica que este método responde a chamadas HTTP PUT.
     * Exemplo de acesso: PUT /api/contacts/1
     */
    @PutMapping("/{id}")
    public Contact updateContact(@PathVariable Long id, @RequestBody Contact updatedContact) {
        // Buscar o contato existente
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado: " + id));

        // Atualizar os campos
        existingContact.setNome(updatedContact.getNome());
        existingContact.setTelefone(updatedContact.getTelefone());
        existingContact.setEmail(updatedContact.getEmail());

        // Salvar alterações
        return contactRepository.save(existingContact);
    }

    /**
     * Método para excluir um contato pelo ID.
     * 
     * @DeleteMapping indica que este método responde a chamadas HTTP DELETE.
     * Exemplo de acesso: DELETE /api/contacts/1
     */
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
    }
}