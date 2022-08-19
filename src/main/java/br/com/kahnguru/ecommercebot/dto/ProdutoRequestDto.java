package br.com.kahnguru.ecommercebot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoRequestDto {

    private String nome;
    private String descricao;
    private String marca;
    private Integer ano;
    private String link;

}
