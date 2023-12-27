package com.nelioalves.cursomc.modelagemconceitual;




import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.cursomc.modelagemconceitual.domain.Categoria;
import com.nelioalves.cursomc.modelagemconceitual.domain.Cidade;
import com.nelioalves.cursomc.modelagemconceitual.domain.Cliente;
import com.nelioalves.cursomc.modelagemconceitual.domain.Endereco;
import com.nelioalves.cursomc.modelagemconceitual.domain.Estado;
import com.nelioalves.cursomc.modelagemconceitual.domain.Pagamento;
import com.nelioalves.cursomc.modelagemconceitual.domain.PagamentoComBoleto;
import com.nelioalves.cursomc.modelagemconceitual.domain.PagamentoComCartao;
import com.nelioalves.cursomc.modelagemconceitual.domain.Pedido;
import com.nelioalves.cursomc.modelagemconceitual.domain.Produto;
import com.nelioalves.cursomc.modelagemconceitual.domain.enuns.EstadoPagamento;
import com.nelioalves.cursomc.modelagemconceitual.domain.enuns.TipoCliente;
import com.nelioalves.cursomc.modelagemconceitual.repositories.CategoriaRepository;
import com.nelioalves.cursomc.modelagemconceitual.repositories.CidadeRepository;
import com.nelioalves.cursomc.modelagemconceitual.repositories.ClienteRepository;
import com.nelioalves.cursomc.modelagemconceitual.repositories.EnderecoRepository;
import com.nelioalves.cursomc.modelagemconceitual.repositories.EstadoRepository;
import com.nelioalves.cursomc.modelagemconceitual.repositories.PagamentoRepository;
import com.nelioalves.cursomc.modelagemconceitual.repositories.PedidoRepository;
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
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	
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
		
		Cliente cl1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "04240638593",TipoCliente.PESSOAFISICA); 
		cl1.getTelefones().addAll(Arrays.asList("7758562050", "7798562050"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "38220684", cl1, cid1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38220684", cl1, cid2);
		
		cl1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		
		clienteRepository.saveAll(Arrays.asList(cl1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cl1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cl1, e2);
		
		cl1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);
		
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		
		ped2.setPagamento(pagto2);
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		
}

}
