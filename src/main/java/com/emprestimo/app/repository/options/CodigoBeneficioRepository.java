package com.emprestimo.app.repository.options;

import com.emprestimo.app.Script.options.CodigobeneficioSql;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.options.CodigoBeneficio;
import com.emprestimo.app.repository.rowMappers.options.RowMapperCodigoBeneficio;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CodigoBeneficioRepository {


    private final JdbcTemplate jdbcTemplate;
    private final RowMapperCodigoBeneficio rowMapperCodigoBeneficio;

    @Inject
    public CodigoBeneficioRepository(@Named(DataBaseConfig.JDBC_DATABASE)JdbcTemplate jdbcTemplate, RowMapperCodigoBeneficio rowMapperCodigoBeneficio) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapperCodigoBeneficio = rowMapperCodigoBeneficio;

    }

    public List<CodigoBeneficio> GetAllCodigoBeneficio() {
        return jdbcTemplate.query(CodigobeneficioSql.SQL_GETCODBENEFICIO.getValue(),rowMapperCodigoBeneficio);
    }

}
