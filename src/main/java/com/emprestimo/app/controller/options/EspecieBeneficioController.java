package com.emprestimo.app.controller.options;

import com.emprestimo.app.dto.options.EspecieBeneficioDto;
import com.emprestimo.app.processor.options.EmpregadorProcessor;
import com.emprestimo.app.processor.options.EspecieBeneficioProcessor;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Inject))
@RequestMapping("/v1/Options/EspecieBeneficio")
public class EspecieBeneficioController {

    private final EspecieBeneficioProcessor especieBeneficioProcessor;

    @GetMapping("ListaEspecieBeneficio")
    public List<EspecieBeneficioDto> GetAllEspecieBeneficio(){
        return especieBeneficioProcessor.getAllCodigoBeneficio();
    }

    @GetMapping("EspecieBeneficio")
    public EspecieBeneficioDto getEspecieBeneficioById(Long id){
        var idespecie = EspecieBeneficioDto.builder().idespecie(id).build();
        return especieBeneficioProcessor.getEspecieBeneficioDtoById(idespecie);
    }




}
