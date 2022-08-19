package br.com.kahnguru.ecommercebot.repository;

import br.com.kahnguru.ecommercebot.model.PrecoProduto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrecoRepository extends JpaRepository<PrecoProduto, Integer> {
}
