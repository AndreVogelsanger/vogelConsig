package com.emprestimo.app.repository.options;

import com.emprestimo.app.Script.options.EspecieBeneficioSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.repository.rowMappers.options.RowMapperEspecieBeneficio;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class EspecieBeneficioRepository {


    private final JdbcTemplate jdbcTemplate;
    private final RowMapperEspecieBeneficio rowMapperEspecieBeneficio;

    @Inject
    public EspecieBeneficioRepository(@Named(DataBaseConfig.JDBC_DATABASE)JdbcTemplate jdbcTemplate, RowMapperEspecieBeneficio rowMapperEspecieBeneficio) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapperEspecieBeneficio = rowMapperEspecieBeneficio;

    }

    public List<com.emprestimo.app.model.options.EspecieBeneficio> GetAllCodigoBeneficio() {
        return jdbcTemplate.query(EspecieBeneficioSQL.SQL_GETESPECIEBENEFICIO.getValue(), rowMapperEspecieBeneficio);
    }

}
