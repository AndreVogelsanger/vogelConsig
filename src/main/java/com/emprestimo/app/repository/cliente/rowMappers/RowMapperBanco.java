package com.emprestimo.app.repository.cliente.rowMappers;

import com.emprestimo.app.model.cliente.Banco;
import com.emprestimo.app.model.cliente.Contato;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class RowMapperBanco implements RowMapper<Banco> {

    @Override
    public Banco mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Banco.builder()
                .idbanco(rs.getLong("idbanco"))
                .idpessoa(rs.getLong("idpessoa"))
                .numbanco(rs.getInt("numbanco"))
                .nomebanco(rs.getString("nomebanco"))
                .agencia(rs.getLong("agencia"))
                .digitoagencia(rs.getInt("digitoagencia"))
                .tipoconta(rs.getString("tipoconta"))
                .numconta(rs.getLong("numconta"))
                .digitoconta(rs.getInt("digitoconta"))
                .statusconta(rs.getString("statusconta"))
                .build();
    }
}
