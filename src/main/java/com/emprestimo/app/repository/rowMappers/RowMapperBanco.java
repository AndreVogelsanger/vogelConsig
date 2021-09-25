package com.emprestimo.app.repository.rowMappers;

import com.emprestimo.app.model.dadosbancario.DadosBancario;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class RowMapperBanco implements RowMapper<DadosBancario> {

    @Override
    public DadosBancario mapRow(ResultSet rs, int rowNum) throws SQLException {

        return DadosBancario.builder()
                .iddadosbancario(rs.getLong("iddadosbancario"))
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
