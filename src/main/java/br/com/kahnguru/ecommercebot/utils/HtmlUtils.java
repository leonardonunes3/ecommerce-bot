package br.com.kahnguru.ecommercebot.utils;

import java.math.BigDecimal;

public class HtmlUtils {

    public static Double getValor(String html) {
        html = html.replace("<span class=\"a-offscreen\">R$", "");
        html = html.replace("</span>", "");
        html = html.replace(".", "");
        html = html.replace(",", ".");

        return Double.parseDouble(html);
    }
}
