package br.com.kahnguru.ecommercebot.service.impl;

import br.com.kahnguru.ecommercebot.model.PrecoProduto;
import br.com.kahnguru.ecommercebot.model.Produto;
import br.com.kahnguru.ecommercebot.service.PrecoProdutoService;
import br.com.kahnguru.ecommercebot.service.WebScrapingService;
import br.com.kahnguru.ecommercebot.utils.HtmlUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
public class WebScrapingServiceImpl implements WebScrapingService {

    final PrecoProdutoService precoProdutoService;

    public WebScrapingServiceImpl(PrecoProdutoService precoProdutoService) {
        this.precoProdutoService = precoProdutoService;
    }

    @Override
    public void search(Produto produto) {
        PrecoProduto precoProduto = new PrecoProduto();

        try {
            Element element = null;
            String link = produto.getLink();
            long start = System.currentTimeMillis();
            while(element == null) {
                Document document = Jsoup.connect(link).get();
                element = document.getElementsByClass("a-offscreen").first();
                if(System.currentTimeMillis() > (start + 10000)){
                    throw new RuntimeException("Não foi possível se conectar ao servidor");
                }
            }
            Double preco = HtmlUtils.getValor(element.toString().trim());

            precoProduto.setPreco(preco);
            precoProduto.setDataHora(LocalDateTime.now());
            precoProduto.setProduto(produto);

            precoProdutoService.addPrecoProduto(precoProduto);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
