package com.emprestimo.app.processor;

import com.emprestimo.app.dto.PessoasDto;
import com.emprestimo.app.model.Pessoas;
import com.emprestimo.app.repository.PessoasRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class PessoasProcessor {

    private final PessoasRepository pessoasRepository;

    @Inject
    public PessoasProcessor(PessoasRepository pessoasRepository) {
        this.pessoasRepository = pessoasRepository;
    }

    public Pessoas getCliente(PessoasDto cliente){
        return pessoasRepository.getCliente(cliente.getNome());
    }

    public List<Pessoas> getClienteList(){
        return pessoasRepository.getClienteList();
    }

}
