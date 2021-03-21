package com.emprestimo.app.processor;

import com.emprestimo.app.dto.ClienteDto;
import com.emprestimo.app.model.Cliente;
import com.emprestimo.app.repository.ClienteRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ClienteProcessor {

    private final ClienteRepository clienteRepository;

    @Inject
    public ClienteProcessor(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente getCliente(ClienteDto cliente){
        return clienteRepository.getCliente(cliente.getNome());
    }

    public List<Cliente> getClienteList(){
        return clienteRepository.getClienteList();
    }

}
