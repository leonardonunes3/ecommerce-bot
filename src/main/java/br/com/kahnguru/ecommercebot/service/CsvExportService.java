package br.com.kahnguru.ecommercebot.service;

import java.io.Writer;

public interface CsvExportService {

    public void writeProdutosToCsv(Writer writer, Integer id);
}
