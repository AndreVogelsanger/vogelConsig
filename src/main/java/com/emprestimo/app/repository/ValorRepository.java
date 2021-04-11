package com.emprestimo.app.repository;

import com.emprestimo.app.Scripty.ValorSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.Valor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Named
public class ValorRepository {

    private final JdbcTemplate jdbcTemplate;

    @Inject
    public ValorRepository(@Named(DataBaseConfig.JDBC_DATABASE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Valor> getValorList(){
        return jdbcTemplate.query (ValorSQL.SQL_GET_LIST_VALOR.getValue(),
                (rs, rowNum) ->
                        Valor.builder()
                                .valorliberado(rs.getBigDecimal("valorliberado"))
                                .producao(rs.getBigDecimal("producao"))
                                .parcela(rs.getBigDecimal("parcela"))
                                .comissao(rs.getBigDecimal("comissao"))
                                .percentual(rs.getBigDecimal("percentual"))
                                .build());
    }


    public void postValorNovo(Valor valor){
        jdbcTemplate.update(ValorSQL.SQL_INSERT_VALOR.getValue(),
                new PreparedStatementSetter(){
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setBigDecimal(1,valor.getValorliberado());
                        ps.setBigDecimal(2,valor.getProducao());
                        ps.setBigDecimal(3,valor.getParcela());
                        ps.setBigDecimal(4,valor.getComissao());
                        ps.setBigDecimal(5,valor.getPercentual());
                    }
                });
    }



}
