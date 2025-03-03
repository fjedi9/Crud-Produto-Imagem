package com.vepilef.spring.crudproduto.models.repositories;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.vepilef.spring.crudproduto.models.Produto;
import com.vepilef.spring.crudproduto.models.repositories.ProdutoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ProdutoRepositoryTest {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	private static final String PRODUTO_NOME = "Produto Teste";
	private static final String PRODUTO_NOME_FILHO = "Produto Filho Teste";
	
	@Before
	public void setUp() throws Exception {
		Produto produto = new Produto();
		produto.setNome(PRODUTO_NOME);
		produto.setDescricao("produto de teste");
		produtoRepository.save(produto);
		
		Produto produtoFilho = new Produto();
		produtoFilho.setNome(PRODUTO_NOME_FILHO);
		produtoFilho.setDescricao("produto de teste para associacao n para 1");
		produtoFilho.setProdutoPai(produtoRepository.findByIdProduto(2));
		produtoRepository.save(produtoFilho);
	}
	
	@After
    public final void tearDown() { 
		produtoRepository.deleteAll();
	}
	
	@Test
	public void findAllTest() {
		List<Produto> produtos = produtoRepository.findAll();
		assertEquals(2, produtos.size());
	}

}
