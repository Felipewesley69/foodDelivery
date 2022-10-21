package com.foodDelivery.modules.restaurante;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodDelivery.modules.cozinha.CozinhaRepository;

@Service
public class RestauranteServiceImpl implements RestauranteService {

	private RestauranteRepository restauranteRepository;
	private CozinhaRepository cozinhaRepository;

	public RestauranteServiceImpl(RestauranteRepository restauranteRepository, CozinhaRepository cozinhaRepository) {
		this.restauranteRepository = restauranteRepository;
		this.cozinhaRepository = cozinhaRepository;
	}

	@Override
	public List<Restaurante> getAll() {
		return restauranteRepository.findAll();
	}

	@Override
	public Restaurante getById(Long id) {
		return restauranteRepository.findById(id).get();
	}

	@Override
	public Restaurante save(RestauranteDTO restauranteDTO) {
		Restaurante r = new Restaurante();
		r.setNome(restauranteDTO.getNome());
		r.setTaxaFrete(restauranteDTO.getTaxaFrete());
		r.setCozinha(cozinhaRepository.findById(restauranteDTO.getIdCozinha()).get());
		return restauranteRepository.save(r);
	}

	@Override
	public Restaurante update(Long id, RestauranteDTO restauranteDTO) {
		Restaurante restauranteAtual = restauranteRepository.findById(id).get();
		restauranteAtual.setNome(restauranteDTO.getNome());
		restauranteAtual.setTaxaFrete(restauranteDTO.getTaxaFrete());
		restauranteAtual.setCozinha(cozinhaRepository.findById(restauranteDTO.getIdCozinha()).get());
		return restauranteRepository.save(restauranteAtual);
	}

	@Override
	public void delete(Long id) {
		restauranteRepository.deleteById(id);
	}

}
