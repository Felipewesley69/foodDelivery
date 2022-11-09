package com.foodDelivery.modules.restaurante;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestauranteRepositoryCustom {
	
	public List<Restaurante> buscarRestaurantes(String nome, BigDecimal taxaInicial, BigDecimal taxaFinal);

}
