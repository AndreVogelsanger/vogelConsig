package com.emprestimo.app.repository.customer;

import com.emprestimo.app.model.cliente.Contato;
import com.emprestimo.app.model.cliente.Pessoa;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class CustomerRowMapperContato implements RowMapper<Contato> {

    @Override
    public Contato mapRow(ResultSet rs, int rowNum) throws SQLException {

        var contato = new Contato();

        //pessoa.setIdpessoa(rs.getLong("idpessoa"));
        contato.setCelular(rs.getString("celular"));
        contato.setTelefone(rs.getString("telefone"));
        contato.setTipotelefone(rs.getString("tipotelefone"));

        return contato;

    }
}
