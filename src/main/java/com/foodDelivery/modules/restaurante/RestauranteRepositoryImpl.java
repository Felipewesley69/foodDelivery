package com.foodDelivery.modules.restaurante;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.foodDelivery.modules.cozinha.Cozinha;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryCustom {

	@PersistenceContext
	private EntityManager maneger;

	@Override
	public List<Restaurante> buscarRestaurantes(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal,
			Long idCozinha) {

		CriteriaBuilder cb = maneger.getCriteriaBuilder();
		CriteriaQuery<Restaurante> quey = cb.createQuery(Restaurante.class);
		Root<Restaurante> restaurante = quey.from(Restaurante.class);

		Join<Restaurante, Cozinha> cozinhaJoin = restaurante.join("cozinha", JoinType.LEFT);

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

		if (idCozinha != null) {
			predicates.add(cb.equal(cozinhaJoin.get("id"), idCozinha));
		}

		quey.where(predicates.toArray(new Predicate[0]));

		return maneger.createQuery(quey).getResultList();

	}

}
