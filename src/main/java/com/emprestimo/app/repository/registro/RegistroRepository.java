package com.emprestimo.app.repository.registro;

import com.emprestimo.app.Script.RegistroSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.registro.Registro;
import com.emprestimo.app.repository.rowMappers.RowMapperRegistro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.PreparedStatement;
import java.util.List;

@Named
public class RegistroRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapperRegistro rowMapperRegistro;

    @Inject
    public RegistroRepository(@Named(DataBaseConfig.JDBC_DATABASE)JdbcTemplate jdbcTemplate, RowMapperRegistro rowMapperRegistro) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapperRegistro = rowMapperRegistro;
    }

    public List<Registro> GetRegistroByIdPessoa(Long idpessoa){
        return jdbcTemplate.query(RegistroSQL.SQL_GET_LIST_REGISTRO.getValue(), rowMapperRegistro,new Object[]{idpessoa});
    }

    @Transactional
    public Registro updateRegistro(Registro registro) {
        jdbcTemplate.update(connection -> {
            PreparedStatement e = connection.prepareStatement(RegistroSQL.SQL_UPDATE_REGISTRO.getValue());
            e.setLong(1,registro.getNumbeneficio());
            e.setLong(2,registro.getMatricula());
            e.setLong(3,registro.getIdregistro());
            return e;
        });
        return registro;
    }

}
