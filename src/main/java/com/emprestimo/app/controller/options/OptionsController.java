package com.emprestimo.app.controller.options;

import com.emprestimo.app.dto.options.EspecieBeneficioDto;
import com.emprestimo.app.dto.options.EmpregadorDto;
import com.emprestimo.app.processor.options.EspecieBeneficioProcessor;
import com.emprestimo.app.processor.options.EmpregadorProcessor;
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


    private final EspecieBeneficioProcessor especieBeneficioProcessor;
    private final EmpregadorProcessor empregadorProcessor;

    @GetMapping("ListaEspecieBeneficio")
    public List<EspecieBeneficioDto> GetAllEspecieBeneficio(){
        return especieBeneficioProcessor.getAllCodigoBeneficio();
    }


    @GetMapping("Empregador")

    public List<EmpregadorDto> GetAllEmpregador(){
        return empregadorProcessor.GetAllEmpregador();
    }

}
