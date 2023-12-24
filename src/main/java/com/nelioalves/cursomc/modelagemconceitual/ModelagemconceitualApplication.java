package com.nelioalves.cursomc.modelagemconceitual;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.modelagemconceitual.domain.Categoria;
import com.nelioalves.cursomc.modelagemconceitual.domain.Cidade;
import com.nelioalves.cursomc.modelagemconceitual.domain.Estado;
import com.nelioalves.cursomc.modelagemconceitual.domain.Produto;
import com.nelioalves.cursomc.modelagemconceitual.repositories.CategoriaRepository;
import com.nelioalves.cursomc.modelagemconceitual.repositories.CidadeRepository;
import com.nelioalves.cursomc.modelagemconceitual.repositories.EstadoRepository;
import com.nelioalves.cursomc.modelagemconceitual.repositories.ProdutoRepository;

@SpringBootApplication
public class ModelagemconceitualApplication implements CommandLineRunner{
    
	@Autowired
	private CategoriaRepository categoriarepository;
	
	@Autowired
	private ProdutoRepository produtorepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ModelagemconceitualApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informticas");
		Categoria cat2 = new Categoria(null, "Escritorios");
		
		Produto p1 = new Produto(null, "Computador"	, 2000.00);
		Produto p2 = new Produto(null, "Impressora"	, 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));	
		
		categoriarepository.saveAll(Arrays.asList(cat1, cat2));
		produtorepository.saveAll(Arrays.asList(p1,p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade cid1 = new Cidade(null, "Uberlandia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2,cid3));
		
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));
		
	
		
	}

}
