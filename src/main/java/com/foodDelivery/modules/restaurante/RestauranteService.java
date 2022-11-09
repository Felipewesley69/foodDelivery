package com.foodDelivery.modules.restaurante;

public interface RestauranteService {
	
	public Restaurante getById(Long id);
	
	public Restaurante save(RestauranteDTO restaurante);
	
	public Restaurante update(Long id, RestauranteDTO restauranteDTO);
	
	public void delete(Long id);
	
}
