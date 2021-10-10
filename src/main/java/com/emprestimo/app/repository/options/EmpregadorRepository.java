package com.emprestimo.app.repository.options;


import com.emprestimo.app.Script.PessoaSQL;
import com.emprestimo.app.Script.options.EmpregadorSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.options.Empregador;
import com.emprestimo.app.model.pessoa.Pessoa;
import com.emprestimo.app.repository.rowMappers.options.RowMapperEmpregador;
import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.PreparedStatement;
import java.util.List;

@Named
public class EmpregadorRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapperEmpregador rowMapperEmpregador;

    @Inject
    public EmpregadorRepository(@Named(DataBaseConfig.JDBC_DATABASE)JdbcTemplate jdbcTemplate, RowMapperEmpregador rowMapperEmpregador) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapperEmpregador = rowMapperEmpregador;
    }

    public List<Empregador> getAllEmpregador(){
        return jdbcTemplate.query(EmpregadorSQL.SQL_GETEMPREGADOR.getValue(), rowMapperEmpregador);
    }


    @Transactional
    public void saveEmpregador(Empregador empregador){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(EmpregadorSQL.SQL_POSTEMPREGADOR.getValue(),new String[]{"idempregador"});
           ps.setString(1, empregador.getEmpregador());
            return ps;
        },keyHolder);
    }

    public Empregador updateEmpregador(Empregador empregador){
        jdbcTemplate.update(EmpregadorSQL.SQL_UPDATE_EMPREGADOR.getValue(),
                ps -> {
            ps.setString(1,empregador.getEmpregador());
            ps.setLong(2,empregador.getIdempregador());
                });
        return empregador;
    }

    public int deleteEmpregador(Long id){
        return jdbcTemplate.update(EmpregadorSQL.SQL_DELETE_EMPREGADOR.getValue(),new Object[]{id});
    }

    public Empregador findByIdEmpregador(Long id) {
        try {
            Empregador empregador = jdbcTemplate.queryForObject(EmpregadorSQL.SQL_GETIDEMPREGADOR.getValue(), rowMapperEmpregador, new Object[]{id});
            return empregador;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

}
