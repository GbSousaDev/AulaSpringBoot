package br.com.gb.gbSpring.service;

import br.com.gb.gbSpring.database.model.ProdutoEntity;
import br.com.gb.gbSpring.dto.ProdutoDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private static final List<ProdutoEntity> PRODUTOS = new ArrayList<>();
    static {
        PRODUTOS.add(ProdutoEntity.builder()
                .id(1)
                .nome("Notebook")
                .preço(new BigDecimal(7000))
                .quantidade(10)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(2)
                .nome("Teclado")
                .preço(new BigDecimal(300))
                .quantidade(10)
                .build());
        PRODUTOS.add(ProdutoEntity.builder()
                .id(3)
                .nome("Mouse")
                .preço(new BigDecimal(180))
                .quantidade(10)
                .build());

    }


    public List<ProdutoEntity> findAll() {
        return new ArrayList<>(PRODUTOS);


    }


    Integer identificador = PRODUTOS.stream()
            .mapToInt(ProdutoEntity::getId)
            .max()
            .orElse(0) + 1;

public ProdutoEntity createProduct(ProdutoDto produtorDto){
       ProdutoEntity novoProduto = ProdutoEntity.builder()
               .id(identificador)
               .nome(produtorDto.getNome())
               .preço(produtorDto.getPreço())
               .quantidade(produtorDto.getQuantidade())
               .build();

       PRODUTOS.add(novoProduto);
        return novoProduto;
}

public ProdutoEntity updateProduct(ProdutoDto produtoDto, Integer id){
    ProdutoEntity produto = PRODUTOS.stream()
            .filter(p -> p.getId().equals(id))
            .findAny()
            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    produto.setNome(produtoDto.getNome());
    produto.setPreço(produtoDto.getPreço());
    produto.setQuantidade(produtoDto.getQuantidade());
    return produto;

}

public void deleteProduct(Integer id){
    PRODUTOS.removeIf( p -> p.getId().equals(id));

}

}
