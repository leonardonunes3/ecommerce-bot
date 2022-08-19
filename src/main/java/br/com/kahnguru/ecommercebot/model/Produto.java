package br.com.kahnguru.ecommercebot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
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

    @Column(length = 512)
    private String link;

    @JsonIgnore
    @OneToMany(mappedBy = "produto")
    private List<PrecoProduto> historicoPreco;

}
