package com.example.springfxcrud.service;
import com.example.springfxcrud.model.Producto;
import com.example.springfxcrud.repository.ProductoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository repo;
    public ProductoService(ProductoRepository repo) { this.repo = repo; }
    public List<Producto> findAll() { return repo.findAll(); }
    public Optional<Producto> findById(Long id) { return repo.findById(id); }
    public Producto save(Producto e) { return repo.save(e); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
