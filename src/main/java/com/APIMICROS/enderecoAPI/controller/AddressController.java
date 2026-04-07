package com.APIMICROS.enderecoAPI.controller;

import com.APIMICROS.enderecoAPI.model.Address;
import com.APIMICROS.enderecoAPI.repository.AddressRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    private final AddressRepository repository;

    public AddressController(AddressRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Address> listAll() {
        return repository.findAll();
    }

    @PostMapping
    public Address create(@RequestBody Address address) {
        return repository.save(address);
    }
}