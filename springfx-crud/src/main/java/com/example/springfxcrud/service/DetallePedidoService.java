package com.example.springfxcrud.service;
import com.example.springfxcrud.model.DetallePedido;
import com.example.springfxcrud.repository.DetallePedidoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoService {
    private final DetallePedidoRepository repo;
    public DetallePedidoService(DetallePedidoRepository repo) { this.repo = repo; }
    public List<DetallePedido> findAll() { return repo.findAll(); }
    public Optional<DetallePedido> findById(Long id) { return repo.findById(id); }
    public DetallePedido save(DetallePedido e) { return repo.save(e); }
    public void deleteById(Long id) { repo.deleteById(id); }
}
