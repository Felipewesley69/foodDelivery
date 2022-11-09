package com.foodDelivery.modules.restaurante;

import java.math.BigDecimal;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	private RestauranteService restauranteService;
	private RestauranteRepository restauranteRepository;

	public RestauranteController(RestauranteService restauranteService, RestauranteRepository restauranteRepository) {
		super();
		this.restauranteService = restauranteService;
		this.restauranteRepository = restauranteRepository;
	}

	@GetMapping
	public ResponseEntity<List<Restaurante>> getAll(
		@RequestParam(required = false) String nome,
		@RequestParam(required = false) BigDecimal taxaFreteInicial,
		@RequestParam(required = false) BigDecimal taxaFreteFinal
	) {
		try {
			return ResponseEntity.ok(restauranteRepository.buscarRestaurantes(nome, taxaFreteInicial, taxaFreteFinal));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Restaurante> getById(@PathVariable("id") Long id) {
		try {
			return ResponseEntity.ok(restauranteService.getById(id));
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	public ResponseEntity<?> save(@RequestBody RestauranteDTO restaurante) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(restauranteService.save(restaurante));
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody RestauranteDTO restauranteDTO) {
		try {
			return ResponseEntity.ok(restauranteService.update(id, restauranteDTO));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {
		try {
			restauranteService.delete(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
}
