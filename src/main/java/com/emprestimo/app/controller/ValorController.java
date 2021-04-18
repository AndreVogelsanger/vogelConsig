package com.emprestimo.app.controller;


import com.emprestimo.app.dto.ValorDto;
import com.emprestimo.app.processor.ValorProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Inject))
public class ValorController {

    private final ValorProcessor valorProcessor;

    @GetMapping("/v1/ListaValor")
    public List<ValorDto> getListaValor(){
        return valorProcessor.getValorList();
    }

    @PostMapping("/v1/ValorNovo")
    @ResponseStatus(HttpStatus.CREATED)
    public void PostValorNovo (@RequestBody ValorDto valorDto){
        valorProcessor.postValorNovo(valorDto);
    }

}
