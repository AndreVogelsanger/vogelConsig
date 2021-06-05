package com.emprestimo.app.repository.cliente.rowMappers;

import com.emprestimo.app.model.cliente.Contato;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class RowMapperContato implements RowMapper<Contato> {

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
