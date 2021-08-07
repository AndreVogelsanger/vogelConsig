package com.emprestimo.app.repository.rowMappers.options;


import com.emprestimo.app.model.options.CodigoBeneficio;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class RowMapperCodigoBeneficio implements RowMapper<CodigoBeneficio> {

    @Override
    public CodigoBeneficio mapRow(ResultSet rs, int rowNum) throws SQLException {

        return CodigoBeneficio.builder()
                .idcodigo(rs.getLong("idcodigo"))
                .codigo(rs.getLong("codigo"))
                .especie(rs.getString("especie"))
                .utilizacao(rs.getString("utilizacao"))
                .build();
    }

}
