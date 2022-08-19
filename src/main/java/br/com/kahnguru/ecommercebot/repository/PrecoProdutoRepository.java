package br.com.kahnguru.ecommercebot.repository;

import br.com.kahnguru.ecommercebot.model.PrecoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrecoProdutoRepository extends JpaRepository<PrecoProduto, Integer> {

    List<PrecoProduto> findAllByProdutoId(Integer id);
}
