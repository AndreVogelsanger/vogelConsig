package com.emprestimo.app.repository.rowMappers.options;

import com.emprestimo.app.model.options.Empregador;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class RowMapperEmpregador implements RowMapper<Empregador> {

    @Override
    public Empregador mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Empregador.builder()
                .idempregador(rs.getLong("idempregador"))
                .empregador(rs.getString("empregador"))
                .build();
    }
}
