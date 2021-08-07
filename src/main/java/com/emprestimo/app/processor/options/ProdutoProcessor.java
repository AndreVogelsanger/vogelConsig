package com.emprestimo.app.processor.options;


import com.emprestimo.app.dto.options.ProdutoDto;
import com.emprestimo.app.repository.options.ProdutoRepository;
import lombok.AllArgsConstructor;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@AllArgsConstructor
public class ProdutoProcessor {

    private final ProdutoRepository produtoRepository;

    public List<ProdutoDto> GetAllProduto(){

        List<ProdutoDto> produtos = new ArrayList<>();
        produtoRepository.getAllProduto().forEach(produto -> {
            var prod = ProdutoDto.builder()
                    .idproduto(produto.getIdproduto())
                    .produto(produto.getProduto())
                    .build();
            produtos.add(prod);

        });

        return produtos;
    }

}
