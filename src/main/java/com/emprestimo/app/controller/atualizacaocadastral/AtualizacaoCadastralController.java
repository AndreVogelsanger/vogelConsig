package com.emprestimo.app.controller.atualizacaocadastral;

import com.emprestimo.app.dto.dadosbancario.DadosBancarioDto;
import com.emprestimo.app.dto.contato.ContatoDto;
import com.emprestimo.app.dto.endereco.EnderecoDto;
import com.emprestimo.app.dto.options.EmpregadorDto;
import com.emprestimo.app.dto.pessoa.PessoaDto;
import com.emprestimo.app.processor.atializacaocadastral.AtualizacaoCadastralProcessor;
import com.emprestimo.app.processor.pessoa.PessoaProcessor;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;


@RestController
@AllArgsConstructor(onConstructor = @__(@Inject))
@RequestMapping("/v1/Atualizar")
public class AtualizacaoCadastralController {

    private final PessoaProcessor pessoaProcessor;
    private final AtualizacaoCadastralProcessor atualizacaoCadastralProcessor;

    @PutMapping("Cliente")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCliente(@RequestBody PessoaDto pessoaDto){
        atualizacaoCadastralProcessor.updateCliente(pessoaDto);
    }

    @PutMapping("DadosBancario")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBanco(@RequestBody List<DadosBancarioDto> dadosBancarioDto){
        atualizacaoCadastralProcessor.updateBanco(dadosBancarioDto);
    }

    @PutMapping("Contato")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateContato(@RequestBody List<ContatoDto> contatoDto){
        atualizacaoCadastralProcessor.updateContato(contatoDto);
    }

    @PutMapping("Endereco")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEndereco(@RequestBody List<EnderecoDto> enderecoDto){
        atualizacaoCadastralProcessor.updateEndereco(enderecoDto);
    }

    @PutMapping("Empregador")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmpregador(@RequestBody EmpregadorDto empregadorDto){
        atualizacaoCadastralProcessor.updateEmpregador(empregadorDto);
    }

}
