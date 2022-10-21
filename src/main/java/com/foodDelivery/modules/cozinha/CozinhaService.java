package com.foodDelivery.modules.cozinha;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface CozinhaService {
	
	public List<Cozinha> getAll();
	
	public Cozinha getById(Long id);
	
	public Cozinha save(Cozinha cozinha);
	
	public Cozinha update(Long id, Cozinha cozinha);
	
	public void delete(Long id);
	
}
