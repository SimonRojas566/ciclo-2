package com.example.springfxcrud.service;
import com.example.springfxcrud.model.Pedido;
import com.example.springfxcrud.repository.PedidoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    private final PedidoRepository repo;
    public PedidoService(PedidoRepository repo) { this.repo = repo; }
    public List<Pedido> findAll() { return repo.findAll(); }
    public Optional<Pedido> findById(Long id) { return repo.findById(id); }
    public Pedido save(Pedido e) { return repo.save(e); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
