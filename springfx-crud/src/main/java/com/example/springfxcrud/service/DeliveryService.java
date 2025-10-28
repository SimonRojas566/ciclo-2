package com.example.springfxcrud.service;
import com.example.springfxcrud.model.Delivery;
import com.example.springfxcrud.repository.DeliveryRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {
    private final DeliveryRepository repo;
    public DeliveryService(DeliveryRepository repo) { this.repo = repo; }
    public List<Delivery> findAll() { return repo.findAll(); }
    public Optional<Delivery> findById(Long id) { return repo.findById(id); }
    public Delivery save(Delivery e) { return repo.save(e); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
