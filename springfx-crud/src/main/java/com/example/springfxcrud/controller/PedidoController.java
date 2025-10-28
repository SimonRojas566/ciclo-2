package com.example.springfxcrud.controller;
import com.example.springfxcrud.model.Pedido;
import com.example.springfxcrud.service.PedidoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
    private final PedidoService service;
    public PedidoController(PedidoService service) { this.service = service; }

    @GetMapping
    public List<Pedido> all() { return service.findAll(); }

    @PostMapping
    public Pedido create(@RequestBody Pedido e) { return service.save(e); }

    @GetMapping("/<built-in function id>")
    public Pedido get(@PathVariable Long id) { return service.findById(id).orElse(null); }

    @PutMapping("/<built-in function id>")
    public Pedido update(@PathVariable Long id, @RequestBody Pedido e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.deleteById(id); }
}
