package com.foodDelivery.modules.permissao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "tbl_permissao")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Permissao {

	@Id
	@EqualsAndHashCode.Include
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "permissao", nullable = false)
	private String permissao;
	
}
