package br.com.gb.gbSpring.database.model;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ProdutoEntity {

    private Integer id;
    private String nome;
    private BigDecimal preço;
    private Integer quantidade;
}
