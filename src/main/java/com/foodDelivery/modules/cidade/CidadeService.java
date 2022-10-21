package com.foodDelivery.modules.cidade;

import java.util.List;

public interface CidadeService {

	public List<Cidade> getAll();
	
	public Cidade getById(Long id);
	
	public Cidade save(CidadeDTO cidadeDTO);
	
	public Cidade update(Long id, CidadeDTO cidadeDTO);
	
	public void delete(Long id);
	
}
