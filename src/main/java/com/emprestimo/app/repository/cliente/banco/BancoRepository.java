package com.emprestimo.app.repository.cliente.banco;

import com.emprestimo.app.Scripty.cliente.BancoSQL;
import com.emprestimo.app.Scripty.cliente.EnderecoSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.cliente.Banco;
import com.emprestimo.app.model.cliente.Endereco;
import com.emprestimo.app.repository.cliente.rowMappers.RowMapperBanco;
import com.emprestimo.app.repository.cliente.rowMappers.RowMapperEndereco;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class BancoRepository {

        private final JdbcTemplate jdbcTemplate;
        private final RowMapperBanco rowMapperBanco;

        @Inject
        public BancoRepository(@Named(DataBaseConfig.JDBC_DATABASE)JdbcTemplate jdbcTemplate, RowMapperBanco rowMapperBanco) {
            this.jdbcTemplate = jdbcTemplate;
            this.rowMapperBanco = rowMapperBanco;
        }

        public List<Banco> GetBancoByIdPessoa(Long idpessoa){
            return jdbcTemplate.query(BancoSQL.SQL_GET_LIST_BANCO.getValue(), rowMapperBanco,new Object[]{idpessoa});
        }

}
