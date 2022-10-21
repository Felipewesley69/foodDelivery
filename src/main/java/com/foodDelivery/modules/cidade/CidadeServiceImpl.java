package com.foodDelivery.modules.cidade;

import java.util.List;

import org.springframework.stereotype.Service;

import com.foodDelivery.modules.estado.EstadoRepository;

@Service
public class CidadeServiceImpl implements CidadeService {
	
	CidadeRepository cidadeRepository;
	EstadoRepository estadoRepository;
	
	public CidadeServiceImpl(CidadeRepository cidadeRepository, EstadoRepository estadoRepository) {
		this.cidadeRepository = cidadeRepository;
		this.estadoRepository = estadoRepository;
	}

	@Override
	public List<Cidade> getAll() {
		return cidadeRepository.findAll();
	}

	@Override
	public Cidade getById(Long id) {
		return cidadeRepository.findById(id).get();
	}

	@Override
	public Cidade save(CidadeDTO cidadeDTO) {
		Cidade cidade = new Cidade();
		cidade.setNome(cidadeDTO.getNome());
		cidade.setEstado(estadoRepository.findById(cidadeDTO.getIdEstado()).get());
		return cidadeRepository.save(cidade);
	}

	@Override
	public Cidade update(Long id, CidadeDTO cidadeDTO) {
		Cidade cidade = cidadeRepository.getById(id);
		cidade.setNome(cidadeDTO.getNome());
		cidade.setEstado(estadoRepository.findById(cidadeDTO.getIdEstado()).get());
		return cidadeRepository.save(cidade);
	}

	@Override
	public void delete(Long id) {
		cidadeRepository.deleteById(id);
	}

}
