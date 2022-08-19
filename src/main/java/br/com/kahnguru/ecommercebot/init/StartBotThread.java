package br.com.kahnguru.ecommercebot.init;

import br.com.kahnguru.ecommercebot.model.Produto;
import br.com.kahnguru.ecommercebot.service.ProdutoService;
import br.com.kahnguru.ecommercebot.service.WebScrapingService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class StartBotThread implements InitializingBean {

    final ProdutoService produtoService;
    final WebScrapingService webScrapingService;


    public StartBotThread(ProdutoService produtoService, WebScrapingService webScrapingService) {
        this.produtoService = produtoService;
        this.webScrapingService = webScrapingService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        ScheduledExecutorService executorService = Executors
                .newSingleThreadScheduledExecutor();

        Runnable task = () -> {
            List<Produto> listaProdutos = produtoService.listAllProdutos();
            listaProdutos.forEach(webScrapingService::search);
        };

        executorService.scheduleWithFixedDelay(task, 0, 1, TimeUnit.MINUTES);
        System.out.println("Bot Iniciado com sucesso");
    }
}
