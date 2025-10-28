package com.example.springfxcrud.service;
import com.example.springfxcrud.model.Categoria;
import com.example.springfxcrud.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    private final CategoriaRepository repo;
    public CategoriaService(CategoriaRepository repo) { this.repo = repo; }
    public List<Categoria> findAll() { return repo.findAll(); }
    public Optional<Categoria> findById(Long id) { return repo.findById(id); }
    public Categoria save(Categoria e) { return repo.save(e); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
