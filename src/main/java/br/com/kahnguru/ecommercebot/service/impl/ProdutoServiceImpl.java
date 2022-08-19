package br.com.kahnguru.ecommercebot.service.impl;

import br.com.kahnguru.ecommercebot.dto.ProdutoRequestDto;
import br.com.kahnguru.ecommercebot.exceptions.ValidacaoException;
import br.com.kahnguru.ecommercebot.model.Produto;
import br.com.kahnguru.ecommercebot.repository.ProdutoRepository;
import br.com.kahnguru.ecommercebot.service.ProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto getProduto(Integer id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ValidacaoException("ID nao encontrado"));
    }

    @Override
    public List<Produto> listAllProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public Produto addProduto(ProdutoRequestDto produtoRequestDto) {
        Produto produto = new Produto();
        produto.setNome(produtoRequestDto.getNome());
        produto.setDescricao(produtoRequestDto.getDescricao());
        produto.setMarca(produtoRequestDto.getMarca());
        produto.setLink(produtoRequestDto.getLink());
        produto.setAno(produtoRequestDto.getAno());

        return produtoRepository.save(produto);
    }

    @Override
    public void deleteProduto(Integer id) {
        produtoRepository.deleteById(id);
    }
}
