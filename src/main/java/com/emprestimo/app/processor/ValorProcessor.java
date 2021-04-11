package com.emprestimo.app.processor;

import com.emprestimo.app.dto.PessoaDto;
import com.emprestimo.app.dto.ValorDto;
import com.emprestimo.app.model.Pessoa;
import com.emprestimo.app.model.Valor;
import com.emprestimo.app.repository.PessoaRepository;
import com.emprestimo.app.repository.ValorRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;


@Named
public class ValorProcessor {

 private final ValorRepository valorRepository;

    @Inject
    public ValorProcessor(ValorRepository valorRepository) {
        this.valorRepository = valorRepository;
    }

    public List<ValorDto> getValorList(){
        List<ValorDto> valores = new ArrayList<>();
        valorRepository.getValorList().stream().forEach(valor -> {
            var v =    ValorDto.builder()
                    .valorliberado(valor.getValorliberado())
                    .producao(valor.getProducao())
                    .parcela(valor.getParcela())
                    .comissao(valor.getComissao())
                    .percentual(valor.getPercentual())
                    .build();
            valores.add(v);
        });
        return valores;
    }

    public void postValorNovo(ValorDto valorDto){
        var valor = Valor.builder()
                .valorliberado(valorDto.getValorliberado())
                .producao(valorDto.getProducao())
                .parcela(valorDto.getParcela())
                .comissao(valorDto.getComissao())
                .percentual(valorDto.getPercentual())
                .build();
        valorRepository.postValorNovo(valor);
    }

}
