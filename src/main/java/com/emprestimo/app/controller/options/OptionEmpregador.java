package com.emprestimo.app.controller.options;


import com.emprestimo.app.dto.options.EmpregadorDto;
import com.emprestimo.app.processor.options.EmpregadorProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Inject))
@RequestMapping("/v1/Options/Empregador")
public class OptionEmpregador {

    private final EmpregadorProcessor empregadorProcessor;

    @GetMapping("Empregadores")
    public List<EmpregadorDto> GetAllEmpregador(){
        return empregadorProcessor.GetAllEmpregador();
    }

    @PostMapping("NovoEmpregador")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveEmpregador(@RequestBody EmpregadorDto empregadorDto){
        empregadorProcessor.saveEmpregador(empregadorDto);
    }

    @GetMapping("EmpregadorId")
    public EmpregadorDto findByIdEmpregador(Long id){
        var dtoidempregador = EmpregadorDto.builder().idempregador(id).build();
        return empregadorProcessor.findByIdEmpregador(dtoidempregador);
    }

    @DeleteMapping("DeletarEmpregador")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(Long id){
        var dtoidempregador = EmpregadorDto.builder().idempregador(id).build();
        empregadorProcessor.deleteEmpregador(dtoidempregador);
        }

}
