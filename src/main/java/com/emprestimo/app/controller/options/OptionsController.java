package com.emprestimo.app.controller.options;

import com.emprestimo.app.dto.options.CodigoBeneficioDto;
import com.emprestimo.app.dto.options.ProdutoDto;
import com.emprestimo.app.processor.options.CodigoBeneficioProcessor;
import com.emprestimo.app.processor.options.ProdutoProcessor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Inject))
@RequestMapping("/v1/Options")
public class OptionsController {


    private final CodigoBeneficioProcessor codigoBeneficioProcessor;
    private final ProdutoProcessor produtoProcessor;

    @GetMapping("ListaCodigoBeneficio")
    public List<CodigoBeneficioDto> GetAllCodigoBeneficio(){
        return codigoBeneficioProcessor.getAllCodigoBeneficio();
    }


    @GetMapping("Produtos")
    public List<ProdutoDto> GetAllProduto(){
        return produtoProcessor.GetAllProduto();
    }

}
