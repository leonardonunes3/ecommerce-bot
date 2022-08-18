package br.com.kahnguru.ecommercebot.repository;

import br.com.kahnguru.ecommercebot.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
