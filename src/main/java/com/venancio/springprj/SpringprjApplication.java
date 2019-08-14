package com.venancio.springprj;

import com.venancio.springprj.domain.Categoria;
import com.venancio.springprj.domain.Cidade;
import com.venancio.springprj.domain.Estado;
import com.venancio.springprj.domain.Produto;
import com.venancio.springprj.repositories.CategoriaRepository;
import com.venancio.springprj.repositories.CidadeRepository;
import com.venancio.springprj.repositories.EstadoRepository;
import com.venancio.springprj.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringprjApplication implements CommandLineRunner  {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	ProdutoRepository produtoRepository;

	@Autowired
	CidadeRepository cidadeRepository;

	@Autowired
	EstadoRepository estadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringprjApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Informatica");
		Categoria cat2 = new Categoria(null, "Escritorio");

		Produto p1 = new Produto(null,"Computador",2000.00);
		Produto p2 = new Produto(null,"Monitor",425.00);
		Produto p3 = new Produto(null,"Teclado",40.00);

		Estado est1 = new Estado(null,"Paraiba");
		Estado est2 = new Estado(null,"Pernambuco");
		Estado est3 = new Estado(null,"São Paulo");

		Cidade cid1 = new Cidade(null, "João Pessoa", est1);
		Cidade cid2 = new Cidade(null, "Recife", est2);
		Cidade cid3 = new Cidade(null, "São Paulo", est3);

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));

		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2));
		est3.getCidades().addAll(Arrays.asList(cid3));

		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll((Arrays.asList(p1,p2,p3)));
		estadoRepository.saveAll((Arrays.asList(est1,est2,est3)));
		cidadeRepository.saveAll((Arrays.asList(cid1,cid2,cid3)));

	}
}
