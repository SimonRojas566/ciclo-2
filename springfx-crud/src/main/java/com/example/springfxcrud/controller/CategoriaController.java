package com.example.springfxcrud.controller;
import com.example.springfxcrud.model.Categoria;
import com.example.springfxcrud.service.CategoriaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    private final CategoriaService service;
    public CategoriaController(CategoriaService service) { this.service = service; }

    @GetMapping
    public List<Categoria> all() { return service.findAll(); }

    @PostMapping
    public Categoria create(@RequestBody Categoria e) { return service.save(e); }

    @GetMapping("/<built-in function id>")
    public Categoria get(@PathVariable Long id) { return service.findById(id).orElse(null); }

    @PutMapping("/<built-in function id>")
    public Categoria update(@PathVariable Long id, @RequestBody Categoria e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.deleteById(id); }
}
