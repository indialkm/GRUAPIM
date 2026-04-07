package com.APIMICROS.enderecoAPI.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Contact {

    /**
     * @Id indica que este campo é a chave primária (primary key) da entidade.
     * @GeneratedValue permite que o banco de dados (ou o provedor JPA) 
     * gere automaticamente um valor único para cada novo registro.
     */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O campo nome não pode estar vazio")
    private String nome;

    @NotBlank(message = "O telefone é obrigatório")
    @Size(min = 8, max = 15, message = "O telefone deve ter entre 8 e 15 caracteres")
    private String telefone;

    @NotBlank(message = "O e-mail é obrigatório")
    @Email(message = "O campo email deve ter um formato válido")
    private String email;

    @OneToMany(mappedBy = "contact", cascade = CascadeType.ALL)
    private List<Address> addresses;
 

    // Construtor vazio exigido pelo JPA
    public Contact() {}

    // Construtor para facilitar a criação de objetos
    public Contact(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    public java.util.List<Address> getAddresses() { 
    	return addresses; 
    }
    
    public void setAddresses( List<Address> addresses) { 
    	this.addresses = addresses; 
    }
}