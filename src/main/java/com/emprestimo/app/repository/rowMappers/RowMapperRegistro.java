package com.emprestimo.app.repository.rowMappers;

import com.emprestimo.app.model.registro.Registro;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class RowMapperRegistro implements RowMapper<Registro> {

    @Override
    public Registro mapRow(ResultSet rs, int rowNum) throws SQLException {

            var registro = new Registro();

            registro.setIdpessoa(rs.getLong("idpessoa"));
            registro.setIdregistro(rs.getLong("idregistro"));
            registro.setNumbeneficio(rs.getLong("numbeneficio"));
            registro.setMatricula(rs.getLong("matricula"));
            return registro;

    }

}
