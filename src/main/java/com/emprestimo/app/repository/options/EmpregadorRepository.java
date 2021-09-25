package com.emprestimo.app.repository.options;


import com.emprestimo.app.Script.options.EmpregadorSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.options.Empregador;
import com.emprestimo.app.repository.rowMappers.options.RowMapperEmpregador;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@AllArgsConstructor
public class EmpregadorRepository {

    @Inject
    private final JdbcTemplate jdbcTemplate;
    @Inject
    private final RowMapperEmpregador rowMapperEmpregador;

//    @Inject
//    public EmpregadorRepository(@Named(DataBaseConfig.JDBC_DATABASE)JdbcTemplate jdbcTemplate, RowMapperEmpregador rowMapperEmpregador) {
//        this.jdbcTemplate = jdbcTemplate;
//        this.rowMapperEmpregador = rowMapperEmpregador;
//    }

    public List<Empregador> getAllEmpregador(){
        return jdbcTemplate.query(EmpregadorSQL.SQL_GETEMPREGADOR.getValue(), rowMapperEmpregador);
    }

}
