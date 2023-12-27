package com.nelioalves.cursomc.modelagemconceitual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.modelagemconceitual.domain.Pedido;
import com.nelioalves.cursomc.modelagemconceitual.repositories.PedidoRepository;
import com.nelioalves.cursomc.modelagemconceitual.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	@Autowired
	private PedidoRepository repo;
    
	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException( "Objeto nao encontrado! Id : " 
		+ id ));
}
}