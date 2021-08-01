package com.emprestimo.app.controller.cliente;

import com.emprestimo.app.dto.cliente.BancoDto;
import com.emprestimo.app.dto.cliente.ContatoDto;
import com.emprestimo.app.dto.cliente.EnderecoDto;
import com.emprestimo.app.dto.cliente.PessoaDto;
import com.emprestimo.app.model.cliente.Contato;
import com.emprestimo.app.processor.cliente.AtualizacaoCadastralProcessor;
import com.emprestimo.app.processor.cliente.PessoaProcessor;
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

    @PutMapping("Banco")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBanco(@RequestBody List<BancoDto> bancoDto){
        atualizacaoCadastralProcessor.updateBanco(bancoDto);
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


}
