package com.example.springfxcrud.controller;
import com.example.springfxcrud.model.Delivery;
import com.example.springfxcrud.service.DeliveryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/delivery")
public class DeliveryController {
    private final DeliveryService service;
    public DeliveryController(DeliveryService service) { this.service = service; }

    @GetMapping
    public List<Delivery> all() { return service.findAll(); }

    @PostMapping
    public Delivery create(@RequestBody Delivery e) { return service.save(e); }

    @GetMapping("/<built-in function id>")
    public Delivery get(@PathVariable Long id) { return service.findById(id).orElse(null); }

    @PutMapping("/<built-in function id>")
    public Delivery update(@PathVariable Long id, @RequestBody Delivery e) {
        e.setId(id);
        return service.save(e);
    }

    @DeleteMapping("/<built-in function id>")
    public void delete(@PathVariable Long id) { service.deleteById(id); }
}
