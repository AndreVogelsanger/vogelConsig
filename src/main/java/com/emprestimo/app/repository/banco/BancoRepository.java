package com.emprestimo.app.repository.banco;

import com.emprestimo.app.Script.BancoSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.banco.Banco;
import com.emprestimo.app.repository.rowMappers.RowMapperBanco;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.PreparedStatement;
import java.util.List;

@Named
public class BancoRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapperBanco rowMapperBanco;

    @Inject
    public BancoRepository(@Named(DataBaseConfig.JDBC_DATABASE) JdbcTemplate jdbcTemplate, RowMapperBanco rowMapperBanco) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapperBanco = rowMapperBanco;
    }

    public List<Banco> GetBancoByIdPessoa(Long idpessoa) {
        return jdbcTemplate.query(BancoSQL.SQL_GET_LIST_BANCO.getValue(), rowMapperBanco, new Object[]{idpessoa});
    }

    @Transactional
    public Banco updateBanco(Banco banco) {
        jdbcTemplate.update(connection -> {
            PreparedStatement bc = connection.prepareStatement(BancoSQL.SQL_UPDATE_BANCO.getValue());
            bc.setInt(1, banco.getNumbanco());
            bc.setString(2, banco.getNomebanco());
            bc.setLong(3, banco.getAgencia());
            bc.setInt(4, banco.getDigitoagencia());
            bc.setString(5, banco.getTipoconta());
            bc.setLong(6, banco.getNumconta());
            bc.setInt(7, banco.getDigitoconta());
            bc.setString(8, banco.getStatusconta());
//            bc.setLong(9, idpessoa);
            bc.setLong(9,banco.getIdbanco());
            return bc;
        });

        return banco;

    }

//    private Long getIdPessoa(String cpf) {
//
//        return jdbcTemplate.queryForObject(PessoaSQL.SQL_GET_IDPESSOA.getValue(), new Object[]{cpf}, Long.class);
//
//    }

//    private Banco getIdBanco(long numBanco) {
//
//        Banco banco = jdbcTemplate.queryForObject(BancoSQL.SQL_GET_ID_BANCO.getValue(), rowMapperBanco, new Object[]{numBanco});
//        return banco;
//
//    }


}
