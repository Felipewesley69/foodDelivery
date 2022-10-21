package com.foodDelivery.modules.restaurante;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface RestauranteService {
	
	public List<Restaurante> getAll();
	
	public Restaurante getById(Long id);
	
	public Restaurante save(RestauranteDTO restaurante);
	
	public Restaurante update(Long id, RestauranteDTO restauranteDTO);
	
	public void delete(Long id);
	
}
