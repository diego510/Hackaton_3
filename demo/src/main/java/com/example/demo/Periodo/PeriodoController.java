package com.example.demo.Periodo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/periodos")
public class PeriodoController {

    private final PeriodoRepository periodoRepository;

    @Autowired
    public PeriodoController(PeriodoRepository periodoRepository) {
        this.periodoRepository = periodoRepository;
    }

    @GetMapping
    public List<Periodo> getAllPeriodos() {
        return periodoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Periodo getPeriodoById(@PathVariable Long id) {
        return periodoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Periodo createPeriodo(@RequestBody Periodo periodo) {
        return periodoRepository.save(periodo);
    }

    @PutMapping("/{id}")
    public Periodo updatePeriodo(@PathVariable Long id, @RequestBody Periodo periodo) {
        if (periodoRepository.existsById(id)) {
            periodo.setId(id);
            return periodoRepository.save(periodo);
        } else {
            return null; // Puedes manejar la respuesta en caso de que el registro no exista
        }
    }

    @DeleteMapping("/{id}")
    public void deletePeriodo(@PathVariable Long id) {
        periodoRepository.deleteById(id);
    }
}