package com.example.springfxcrud.service;
import com.example.springfxcrud.model.Repartidor;
import com.example.springfxcrud.repository.RepartidorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RepartidorService {
    private final RepartidorRepository repo;
    public RepartidorService(RepartidorRepository repo) { this.repo = repo; }
    public List<Repartidor> findAll() { return repo.findAll(); }
    public Optional<Repartidor> findById(Long id) { return repo.findById(id); }
    public Repartidor save(Repartidor e) { return repo.save(e); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
