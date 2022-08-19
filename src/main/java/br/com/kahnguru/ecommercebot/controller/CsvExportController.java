package br.com.kahnguru.ecommercebot.controller;

import br.com.kahnguru.ecommercebot.service.CsvExportService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.IOException;

@RestController
@RequestMapping("/export")
public class CsvExportController {

    final CsvExportService csvExportService;

    public CsvExportController(CsvExportService csvExportService) {
        this.csvExportService = csvExportService;
    }

    @GetMapping("/{id}")
    public void getAllPrecosInCsv(@PathParam(value = "id") Integer id, HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"produtos.csv\"");
        csvExportService.writeProdutosToCsv(servletResponse.getWriter(), id);
    }

}
