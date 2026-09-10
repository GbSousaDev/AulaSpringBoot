package br.com.gb.gbSpring.controller;

import br.com.gb.gbSpring.database.model.ProdutoEntity;
import br.com.gb.gbSpring.dto.ProdutoDto;
import br.com.gb.gbSpring.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor

public class ProdutoController {
    private final ProdutoService produtoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoEntity> findAll() {
        return produtoService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity createProduct(@RequestBody ProdutoDto produtoDto) {
      return produtoService.createProduct(produtoDto);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoEntity updateProduct(@PathVariable Integer id, ProdutoDto produtoDto) {
      return produtoService.updateProduct(produtoDto, id);


    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) {
        produtoService.deleteProduct(id);
    }


}
