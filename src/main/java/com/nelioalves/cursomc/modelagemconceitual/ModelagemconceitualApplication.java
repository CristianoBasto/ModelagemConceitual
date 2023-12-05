package com.nelioalves.cursomc.modelagemconceitual;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.modelagemconceitual.domain.Categoria;
import com.nelioalves.cursomc.modelagemconceitual.repositories.CategoriaRepository;

@SpringBootApplication
public class ModelagemconceitualApplication implements CommandLineRunner{
    
	@Autowired
	private CategoriaRepository categoriarepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ModelagemconceitualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informticas");
		Categoria cat2 = new Categoria(null, "Escritorios");
		
		categoriarepository.saveAll(Arrays.asList(cat1, cat2));
		
	}

}
