package com.emprestimo.app.model.pessoa;

import com.emprestimo.app.model.dadosbancario.DadosBancario;
import com.emprestimo.app.model.contato.Contato;
import com.emprestimo.app.model.endereco.Endereco;
import com.emprestimo.app.model.registro.Registro;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    private Long idpessoa;
    private String nome;
    private String cpf;
    private String rg;
    private Date dataemissaorg;
    private String ufrg;
    private BigDecimal renda;
    private Date datanascimento;
    private String naturalidae;
    private String estadonascimento;
    private String estadocivil;
    private String nomepai;
    private String nomemae;
    private String email;
    private String indicacao;

    private List<Contato> contatos;
    private List<Endereco> enderecos;
    private List<DadosBancario> dadosbancario;
    private List<Registro> registros;

}
