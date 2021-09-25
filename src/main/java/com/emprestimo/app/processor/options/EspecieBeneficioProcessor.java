package com.emprestimo.app.processor.options;


import com.emprestimo.app.dto.options.EspecieBeneficioDto;
import com.emprestimo.app.repository.options.EspecieBeneficioRepository;
import lombok.AllArgsConstructor;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@AllArgsConstructor
public class EspecieBeneficioProcessor {

        private final EspecieBeneficioRepository especieBeneficioRepository;


    public List<EspecieBeneficioDto> getAllCodigoBeneficio(){

        List<EspecieBeneficioDto> codigos = new ArrayList<>();
        especieBeneficioRepository.GetAllCodigoBeneficio().forEach(codigo ->{
            var cod = EspecieBeneficioDto.builder()
                    .idespecie(codigo.getIdespecie())
                    .codigo(codigo.getCodigo())
                    .especie(codigo.getEspecie())
                    .utilizacao(codigo.getUtilizacao())
                    .build();
            codigos.add(cod);
        });

        return codigos;
    }

}
