package com.foodDelivery.modules.formaPagamento;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tbl_forma_pagamento")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class FormaPagamento {

	@Id
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
}
