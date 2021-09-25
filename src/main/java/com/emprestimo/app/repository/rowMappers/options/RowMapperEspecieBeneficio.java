package com.emprestimo.app.repository.rowMappers.options;


import com.emprestimo.app.model.options.EspecieBeneficio;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class RowMapperEspecieBeneficio implements RowMapper<EspecieBeneficio> {

    @Override
    public EspecieBeneficio mapRow(ResultSet rs, int rowNum) throws SQLException {

        return EspecieBeneficio.builder()
                .idespecie(rs.getLong("idespecie"))
                .codigo(rs.getLong("codigo"))
                .especie(rs.getString("especie"))
                .utilizacao(rs.getString("utilizacao"))
                .build();
    }

}
