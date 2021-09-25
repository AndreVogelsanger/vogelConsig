package com.emprestimo.app.repository.dadosbancario;

import com.emprestimo.app.Script.DadosBancarioSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.dadosbancario.DadosBancario;
import com.emprestimo.app.repository.rowMappers.RowMapperBanco;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.PreparedStatement;
import java.util.List;

@Named
public class DadosBancarioRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapperBanco rowMapperBanco;

    @Inject
    public DadosBancarioRepository(@Named(DataBaseConfig.JDBC_DATABASE) JdbcTemplate jdbcTemplate, RowMapperBanco rowMapperBanco) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapperBanco = rowMapperBanco;
    }

    public List<DadosBancario> GetBancoByIdPessoa(Long idpessoa) {
        return jdbcTemplate.query(DadosBancarioSQL.SQL_GET_LIST_DADOSBANCARIO.getValue(), rowMapperBanco, new Object[]{idpessoa});
    }

    @Transactional
    public DadosBancario updateDadosBancario(DadosBancario dadosBancario) {
        jdbcTemplate.update(connection -> {
            PreparedStatement bc = connection.prepareStatement(DadosBancarioSQL.SQL_UPDATE_DADOSBANCARIO.getValue());
            bc.setInt(1, dadosBancario.getNumbanco());
            bc.setString(2, dadosBancario.getNomebanco());
            bc.setLong(3, dadosBancario.getAgencia());
            bc.setInt(4, dadosBancario.getDigitoagencia());
            bc.setString(5, dadosBancario.getTipoconta());
            bc.setLong(6, dadosBancario.getNumconta());
            bc.setInt(7, dadosBancario.getDigitoconta());
            bc.setString(8, dadosBancario.getStatusconta());
//            bc.setLong(9, idpessoa);
            bc.setLong(9, dadosBancario.getIddadosbancario());
            return bc;
        });

        return dadosBancario;

    }

//    private Long getIdPessoa(String cpf) {
//
//        return jdbcTemplate.queryForObject(PessoaSQL.SQL_GET_IDPESSOA.getValue(), new Object[]{cpf}, Long.class);
//
//    }

//    private DadosBancario getIdBanco(long numBanco) {
//
//        DadosBancario banco = jdbcTemplate.queryForObject(DadosBancarioSQL.SQL_GET_ID_BANCO.getValue(), rowMapperBanco, new Object[]{numBanco});
//        return banco;
//
//    }


}
