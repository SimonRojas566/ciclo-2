package com.example.springfxcrud.service;
import com.example.springfxcrud.model.Cliente;
import com.example.springfxcrud.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository repo;
    public ClienteService(ClienteRepository repo) { this.repo = repo; }
    public List<Cliente> findAll() { return repo.findAll(); }
    public Optional<Cliente> findById(Long id) { return repo.findById(id); }
    public Cliente save(Cliente e) { return repo.save(e); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
