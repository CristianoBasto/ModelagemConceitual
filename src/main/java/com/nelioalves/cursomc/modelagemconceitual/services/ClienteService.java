package com.nelioalves.cursomc.modelagemconceitual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.modelagemconceitual.domain.Cliente;
import com.nelioalves.cursomc.modelagemconceitual.repositories.ClienteRepository;
import com.nelioalves.cursomc.modelagemconceitual.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	@Autowired
	private ClienteRepository repo;
    
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException( "Objeto nao encontrado! Id : " 
		+ id ));
}
}