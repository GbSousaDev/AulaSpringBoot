package br.com.gb.gbSpring.dto;

import lombok.*;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class ProdutoDto {
    private String nome;
    private BigDecimal preço;
    private Integer quantidade;
}
