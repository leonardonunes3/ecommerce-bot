package br.com.kahnguru.ecommercebot.service.impl;

import br.com.kahnguru.ecommercebot.exceptions.ValidacaoException;
import br.com.kahnguru.ecommercebot.model.PrecoProduto;
import br.com.kahnguru.ecommercebot.repository.PrecoProdutoRepository;
import br.com.kahnguru.ecommercebot.service.CsvExportService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CsvExportServiceImpl implements CsvExportService {

    final PrecoProdutoRepository precoProdutoRepository;

    public CsvExportServiceImpl(PrecoProdutoRepository precoProdutoRepository) {
        this.precoProdutoRepository = precoProdutoRepository;
    }

    @Override
    public void writeProdutosToCsv(Writer writer, Integer id) {
        Double maxValue = Double.MIN_VALUE, minValue = Double.MAX_VALUE;
        LocalDateTime dataMaxValue = LocalDateTime.now(), dataMinValue = LocalDateTime.now();

        List<PrecoProduto> precoProdutos = precoProdutoRepository.findAllByProdutoId(id);
        if(precoProdutos.isEmpty()) {
            throw new ValidacaoException("Produto com id informado não possui registros.");
        }
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("Nome", "Marca", "Ano", "Descricao");
            csvPrinter.printRecord(precoProdutos.get(0).getProduto().getNome(),
                    precoProdutos.get(0).getProduto().getMarca(),
                    precoProdutos.get(0).getProduto().getAno(),
                    precoProdutos.get(0).getProduto().getDescricao());
            csvPrinter.println();
            csvPrinter.printRecord("Data", "Preco");
            for (PrecoProduto precoProduto : precoProdutos) {
                csvPrinter.printRecord(precoProduto.getDataHora(), precoProduto.getPreco());
                if(precoProduto.getPreco() > maxValue) {
                    maxValue = precoProduto.getPreco();
                    dataMaxValue = precoProduto.getDataHora();
                }
                if(precoProduto.getPreco() < minValue) {
                    minValue = precoProduto.getPreco();
                    dataMinValue = precoProduto.getDataHora();
                }
            }
            csvPrinter.println();
            csvPrinter.printRecord("Menor Preco", "Data Menor Preco", "Maior Preco", "Data Maior Preco");
            csvPrinter.printRecord(minValue, dataMinValue, maxValue, dataMaxValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
