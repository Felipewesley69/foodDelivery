package com.foodDelivery.modules.cozinha;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tbl_cozinha")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cozinha {
	
	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome_cozinha", length = 50, nullable = false)
	private String nome;
	
}
