package com.foodDelivery.modules.estado;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/estados")
public class EstadoController {
	
	EstadoService estadoService;
	
	public EstadoController(EstadoService estadoService) {
		this.estadoService = estadoService;
	}

	@GetMapping
	public ResponseEntity<List<Estado>> getAll() {
		try {
			return ResponseEntity.ok(estadoService.getAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(estadoService.getById(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Estado estado) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(estadoService.save(estado));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Estado estado) {
		try {
			return ResponseEntity.ok(estadoService.update(id, estado));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		try {
			estadoService.delete(id);
			return ResponseEntity.ok(null);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
}
