package com.nelioalves.cursomc.modelagemconceitual.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nelioalves.cursomc.modelagemconceitual.domain.Categoria;
import com.nelioalves.cursomc.modelagemconceitual.repositories.CategoriaRepository;
import com.nelioalves.cursomc.modelagemconceitual.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repo;
    
	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException( "Objeto nao encontrado! Id : " 
		+ id ));
}
}