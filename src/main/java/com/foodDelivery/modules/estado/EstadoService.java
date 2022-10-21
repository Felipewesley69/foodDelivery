package com.foodDelivery.modules.estado;

import java.util.List;

public interface EstadoService {
	
	public List<Estado> getAll();
	
	public Estado getById(Long id);
	
	public Estado save(Estado estado);
	
	public Estado update(Long id, Estado estado);
	
	public void delete(Long id);

}
