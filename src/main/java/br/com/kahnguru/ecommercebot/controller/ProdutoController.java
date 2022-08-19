package br.com.kahnguru.ecommercebot.controller;

import br.com.kahnguru.ecommercebot.dto.ProdutoRequestDto;
import br.com.kahnguru.ecommercebot.model.Produto;
import br.com.kahnguru.ecommercebot.model.Teste;
import br.com.kahnguru.ecommercebot.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<Produto> addProduto(@RequestBody ProdutoRequestDto produtoRequestDto) {
        return ResponseEntity.ok(produtoService.addProduto(produtoRequestDto));
    }
}
