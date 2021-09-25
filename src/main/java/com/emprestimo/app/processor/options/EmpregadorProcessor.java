package com.emprestimo.app.processor.options;


import com.emprestimo.app.dto.options.EmpregadorDto;
import com.emprestimo.app.repository.options.EmpregadorRepository;
import lombok.AllArgsConstructor;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@AllArgsConstructor
public class EmpregadorProcessor {

    private final EmpregadorRepository empregadorRepository;

    public List<EmpregadorDto> GetAllEmpregador(){

        List<EmpregadorDto> empregadores = new ArrayList<>();
        empregadorRepository.getAllEmpregador().forEach(produto -> {
            var prod = EmpregadorDto.builder()
                    .idempregador(produto.getIdempregador())
                    .empregador(produto.getEmpregador())
                    .build();
            empregadores.add(prod);

        });

        return empregadores;
    }

}
