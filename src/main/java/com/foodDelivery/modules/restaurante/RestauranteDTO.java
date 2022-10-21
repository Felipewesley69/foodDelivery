package com.foodDelivery.modules.restaurante;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor 
public class RestauranteDTO {
	private Long id;
	private String nome;
	private BigDecimal taxaFrete;
	private Long idCozinha;
}
