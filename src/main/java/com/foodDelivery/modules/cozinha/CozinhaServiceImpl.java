package com.foodDelivery.modules.cozinha;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CozinhaServiceImpl implements CozinhaService {

	private CozinhaRepository cozinhaRepository;

	public CozinhaServiceImpl(CozinhaRepository cozinhaRepository) {
		this.cozinhaRepository = cozinhaRepository;
	}

	@Override
	public List<Cozinha> getAll() {
		return cozinhaRepository.findAll();
	}

	@Override
	public Cozinha getById(Long id) {
		return cozinhaRepository.findById(id).get();
	}

	@Override
	public Cozinha save(Cozinha cozinha) {
		return cozinhaRepository.save(cozinha);
	}

	@Override
	public Cozinha update(Long id, Cozinha cozinha) {
		Cozinha cozinhaAtualizada = cozinhaRepository.findById(id).get();
		cozinhaAtualizada.setNome(cozinha.getNome());
		return cozinhaRepository.save(cozinhaAtualizada);
	}

	@Override
	public void delete(Long id) {
		cozinhaRepository.deleteById(id);
	}

	@Override
	public List<Cozinha> findByNome(String nome) {
		return cozinhaRepository.findByNomeContaining(nome);
	}

}
