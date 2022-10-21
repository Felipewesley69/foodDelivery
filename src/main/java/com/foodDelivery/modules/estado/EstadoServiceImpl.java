package com.foodDelivery.modules.estado;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class EstadoServiceImpl implements EstadoService {

	EstadoRepository estadoRespository;
	
	public EstadoServiceImpl(EstadoRepository estadoRespository) {
		this.estadoRespository = estadoRespository;
	}

	@Override
	public List<Estado> getAll() {
		return estadoRespository.findAll();
	}

	@Override
	public Estado getById(Long id) {
		return estadoRespository.findById(id).get();
	}

	@Override
	public Estado save(Estado estado) {
		return estadoRespository.save(estado);
	}

	@Override
	public Estado update(Long id, Estado estado) {
		Estado estadoAtual = estadoRespository.findById(id).get();
		BeanUtils.copyProperties(estado, estadoAtual, "id");
		return estadoRespository.save(estadoAtual);
	}

	@Override
	public void delete(Long id) {
		estadoRespository.deleteById(id);
	}

}
