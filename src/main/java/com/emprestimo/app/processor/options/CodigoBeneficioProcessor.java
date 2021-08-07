package com.emprestimo.app.processor.options;


import com.emprestimo.app.dto.options.CodigoBeneficioDto;
import com.emprestimo.app.repository.options.CodigoBeneficioRepository;
import lombok.AllArgsConstructor;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@AllArgsConstructor
public class CodigoBeneficioProcessor {

        private final CodigoBeneficioRepository codigoBeneficioRepository;


    public List<CodigoBeneficioDto> getAllCodigoBeneficio(){

        List<CodigoBeneficioDto> codigos = new ArrayList<>();
        codigoBeneficioRepository.GetAllCodigoBeneficio().forEach(codigo ->{
            var cod = CodigoBeneficioDto.builder()
                    .idcodigo(codigo.getIdcodigo())
                    .codigo(codigo.getCodigo())
                    .especie(codigo.getEspecie())
                    .utilizacao(codigo.getUtilizacao())
                    .build();
            codigos.add(cod);
        });

        return codigos;
    }

}
