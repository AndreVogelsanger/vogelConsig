package com.emprestimo.app.repository.rowMappers;

import com.emprestimo.app.model.contato.Contato;
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
            .descricao(rs.getString("descricao"))
            .build();

    }
}
