package com.example.springfxcrud.controller;
import com.example.springfxcrud.model.Producto;
import com.example.springfxcrud.service.ProductoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    private final ProductoService service;
    public ProductoController(ProductoService service) { this.service = service; }

    @GetMapping
    public List<Producto> all() { return service.findAll(); }

    @PostMapping
    public Producto create(@RequestBody Producto e) { return service.save(e); }

    @GetMapping("/<built-in function id>")
    public Producto get(@PathVariable Long id) { return service.findById(id).orElse(null); }

    @PutMapping("/<built-in function id>")
    public Producto update(@PathVariable Long id, @RequestBody Producto e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.deleteById(id); }
}
