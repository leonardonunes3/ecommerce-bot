package br.com.kahnguru.ecommercebot.service;

import br.com.kahnguru.ecommercebot.dto.ProdutoRequestDto;
import br.com.kahnguru.ecommercebot.model.Produto;

import java.util.List;

public interface ProdutoService {

    Produto getProduto(Integer id);

    List<Produto> listAllProdutos();

    Produto addProduto(ProdutoRequestDto produtoRequestDto);

    void deleteProduto(Integer id);
}
