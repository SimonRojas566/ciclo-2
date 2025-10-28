package com.example.springfxcrud.controller;
import com.example.springfxcrud.model.DetallePedido;
import com.example.springfxcrud.service.DetallePedidoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/detallepedido")
public class DetallePedidoController {
    private final DetallePedidoService service;
    public DetallePedidoController(DetallePedidoService service) { this.service = service; }

    @GetMapping
    public List<DetallePedido> all() { return service.findAll(); }

    @PostMapping
    public DetallePedido create(@RequestBody DetallePedido e) { return service.save(e); }

    @GetMapping("/<built-in function id>")
    public DetallePedido get(@PathVariable Long id) { return service.findById(id).orElse(null); }

    @PutMapping("/<built-in function id>")
    public DetallePedido update(@PathVariable Long id, @RequestBody DetallePedido e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.deleteById(id); }
}
