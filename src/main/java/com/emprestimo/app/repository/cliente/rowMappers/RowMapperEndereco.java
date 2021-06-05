package com.emprestimo.app.repository.cliente.rowMappers;

import com.emprestimo.app.model.cliente.Endereco;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class RowMapperEndereco implements RowMapper<Endereco> {

    @Override
    public Endereco mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Endereco.builder()
                .idpessoa(rs.getLong("idpessoa"))
                .logradouro(rs.getString("logradouro"))
                .tipologradouro(rs.getString("tipologradouro"))
                .cep(rs.getString("cep"))
                .uf(rs.getString("uf"))
                .bairro(rs.getString("bairro"))
                .cidade(rs.getString("cidade"))
                .estado(rs.getString("estado"))
                .build();
    }

}
