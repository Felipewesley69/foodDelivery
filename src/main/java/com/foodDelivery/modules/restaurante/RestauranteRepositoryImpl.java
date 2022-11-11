package com.foodDelivery.modules.restaurante;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryCustom {

	@PersistenceContext
	private EntityManager maneger;

	@Override
	public List<Restaurante> buscarRestaurantes(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

		CriteriaBuilder cb = maneger.getCriteriaBuilder();
		CriteriaQuery<Restaurante> quey = cb.createQuery(Restaurante.class);
		Root<Restaurante> restaurante = quey.from(Restaurante.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (nome != null) {
			predicates.add(cb.like(cb.lower(restaurante.get("nome")), "%" + nome.toLowerCase() + "%"));
		}

		if (taxaFreteInicial != null) {
			predicates.add(cb.greaterThanOrEqualTo(restaurante.get("taxaFrete"), taxaFreteInicial));
		}

		if (taxaFreteFinal != null) {
			predicates.add(cb.lessThanOrEqualTo(restaurante.get("taxaFrete"), taxaFreteFinal));
		}

		quey.where(predicates.toArray(new Predicate[0]));

		return maneger.createQuery(quey).getResultList();

	}

}
