package br.com.kahnguru.ecommercebot.service.impl;

import br.com.kahnguru.ecommercebot.model.PrecoProduto;
import br.com.kahnguru.ecommercebot.repository.PrecoProdutoRepository;
import br.com.kahnguru.ecommercebot.service.PrecoProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecoProdutoServiceImpl implements PrecoProdutoService {

    final PrecoProdutoRepository precoProdutoRepository;

    public PrecoProdutoServiceImpl(PrecoProdutoRepository precoProdutoRepository) {
        this.precoProdutoRepository = precoProdutoRepository;
    }

    @Override
    public List<PrecoProduto> listAllPrecoProduto(Integer id) {
        return precoProdutoRepository.findAllByProdutoId(id);
    }

    @Override
    public PrecoProduto addPrecoProduto(PrecoProduto precoProduto) {
        return precoProdutoRepository.save(precoProduto);
    }

    @Override
    public void deletePrecoProduto(Integer id) {
        precoProdutoRepository.deleteById(id);
    }
}
