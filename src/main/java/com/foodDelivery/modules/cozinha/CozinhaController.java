package com.foodDelivery.modules.cozinha;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
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
@RequestMapping("/cozinhas")
public class CozinhaController {

	private CozinhaService cozinhaService;

	public CozinhaController(CozinhaService cozinhaService) {
		this.cozinhaService = cozinhaService;
	}

	@GetMapping
	public ResponseEntity<List<Cozinha>> getAll() {
		try {
			return ResponseEntity.ok(cozinhaService.getAll());
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Cozinha> getById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(cozinhaService.getById(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Cozinha cozinha) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(cozinhaService.save(cozinha));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Cozinha> update(@PathVariable("id") Long id, @RequestBody Cozinha cozinha) {
		try {
			return ResponseEntity.ok(cozinhaService.update(id, cozinha));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		try {
			cozinhaService.delete(id);
			return ResponseEntity.ok(null);
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Essa cozinha está atribuida a um restaurante.");
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

}
