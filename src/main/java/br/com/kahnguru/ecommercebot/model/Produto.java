package br.com.kahnguru.ecommercebot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String descricao;
    private String marca;
    private Integer ano;
    private String link;

    @OneToMany(mappedBy = "produto")
    private List<PrecoProduto> historicoPreco;

}
