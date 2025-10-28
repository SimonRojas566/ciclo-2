package com.example.springfxcrud.controller;
import com.example.springfxcrud.model.Cliente;
import com.example.springfxcrud.service.ClienteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
    private final ClienteService service;
    public ClienteController(ClienteService service) { this.service = service; }

    @GetMapping
    public List<Cliente> all() { return service.findAll(); }

    @PostMapping
    public Cliente create(@RequestBody Cliente e) { return service.save(e); }

    @GetMapping("/<built-in function id>")
    public Cliente get(@PathVariable Long id) { return service.findById(id).orElse(null); }

    @PutMapping("/<built-in function id>")
    public Cliente update(@PathVariable Long id, @RequestBody Cliente e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.deleteById(id); }
}
