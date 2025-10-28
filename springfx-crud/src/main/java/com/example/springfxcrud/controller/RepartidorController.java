package com.example.springfxcrud.controller;
import com.example.springfxcrud.model.Repartidor;
import com.example.springfxcrud.service.RepartidorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/repartidor")
public class RepartidorController {
    private final RepartidorService service;
    public RepartidorController(RepartidorService service) { this.service = service; }

    @GetMapping
    public List<Repartidor> all() { return service.findAll(); }

    @PostMapping
    public Repartidor create(@RequestBody Repartidor e) { return service.save(e); }

    @GetMapping("/<built-in function id>")
    public Repartidor get(@PathVariable Long id) { return service.findById(id).orElse(null); }

    @PutMapping("/<built-in function id>")
    public Repartidor update(@PathVariable Long id, @RequestBody Repartidor e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.deleteById(id); }
}
