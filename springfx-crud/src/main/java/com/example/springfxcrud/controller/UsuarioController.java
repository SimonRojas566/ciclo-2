package com.example.springfxcrud.controller;
import com.example.springfxcrud.model.Usuario;
import com.example.springfxcrud.service.UsuarioService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioService service;
    public UsuarioController(UsuarioService service) { this.service = service; }

    @GetMapping
    public List<Usuario> all() { return service.findAll(); }

    @PostMapping
    public Usuario create(@RequestBody Usuario e) { return service.save(e); }

    @GetMapping("/<built-in function id>")
    public Usuario get(@PathVariable Long id) { return service.findById(id).orElse(null); }

    @PutMapping("/<built-in function id>")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.deleteById(id); }
}
