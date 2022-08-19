package br.com.kahnguru.ecommercebot.service;

import br.com.kahnguru.ecommercebot.dto.ProdutoRequestDto;
import br.com.kahnguru.ecommercebot.model.PrecoProduto;
import br.com.kahnguru.ecommercebot.model.Produto;

import java.util.List;

public interface PrecoProdutoService {

    List<PrecoProduto> listAllPrecoProduto(Integer id);

    PrecoProduto addPrecoProduto(PrecoProduto precoProduto);

    void deletePrecoProduto(Integer id);
}
