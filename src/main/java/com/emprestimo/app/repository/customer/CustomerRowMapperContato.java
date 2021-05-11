package com.emprestimo.app.repository.customer;

import com.emprestimo.app.model.cliente.Contato;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Named
public class CustomerRowMapperContato implements RowMapper<Contato> {

    @Override
    public Contato mapRow(ResultSet rs, int rowNum) throws SQLException {

            return Contato.builder()
            .idpessoa(rs.getLong("idpessoa"))
            .numero(rs.getString("numero"))
            .tipocontato(rs.getString("tipocontato"))
            .decricao(rs.getString("descricao"))
            .build();

    }
}
