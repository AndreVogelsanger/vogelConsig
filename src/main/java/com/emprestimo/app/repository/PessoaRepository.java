package com.emprestimo.app.repository;

import com.emprestimo.app.Scripty.PessoaSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.cliente.Pessoa;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;

import java.sql.Date;
import java.util.List;


@Named
public class PessoaRepository {

    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper;

    @Inject
    public PessoaRepository(@Named(DataBaseConfig.JDBC_DATABASE) JdbcTemplate jdbcTemplate, CustomerRowMapper customerRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerRowMapper = customerRowMapper;
    }

    public List<Pessoa> findAll(){
        List<Pessoa> pessoa = jdbcTemplate.query(PessoaSQL.SQL_GET_LIST_PESSOAS.getValue(),customerRowMapper);
        return pessoa;
    }

    public Pessoa findByCpf(String cpf){
        Pessoa pessoa = jdbcTemplate.queryForObject(PessoaSQL.SQL_GET_CPFPESSOA.getValue(),customerRowMapper, new Object[]{cpf});
        return pessoa;
    }

    public Pessoa findByNome(String nome){
        Pessoa pessoa = jdbcTemplate.queryForObject(PessoaSQL.SQL_GET_NOMEPESSOA.getValue(),customerRowMapper, new Object[]{nome});
        return pessoa;
    }

    public void Save(Pessoa pessoa){
         jdbcTemplate.update(PessoaSQL.SQL_INSERT_PESSOA.getValue(),
                 ps -> {
                     ps.setString(1, pessoa.getNome());
                     ps.setString(2, pessoa.getCpf());
                     ps.setString(3, pessoa.getRg());
                     ps.setDate(4, new Date(pessoa.getDataemissaorg().getTime())); // VERIFICAR DATA tratar se null.
                     ps.setString(5,pessoa.getUfrg());
                     ps.setBigDecimal(6, pessoa.getRenda());
                     ps.setDate(7, new Date(pessoa.getDatanascimento().getTime()));
                     ps.setString(8, pessoa.getNaturalidae());
                     ps.setString(9, pessoa.getEstadonascimento());
                     ps.setString(10, pessoa.getEstadocivil());
                     ps.setString(11, pessoa.getNomepai());
                     ps.setString(12, pessoa.getNomemae());
                     ps.setString(13, pessoa.getEmail());
                     ps.setString(14, pessoa.getIndicacao());
                     ps.setString(15, pessoa.getNumbeneficio());
                     ps.setString(16, pessoa.getMatricula());
                 });
    }

    public int Delete(Pessoa pessoa) {
        return jdbcTemplate.update(PessoaSQL.SQL_DELETE_CPFPESSOA.getValue(), new Object[]{pessoa.getCpf()});
    }

    public void update(Pessoa pessoa){
        jdbcTemplate.update(PessoaSQL.SQL_UPDATE_PESSOA.getValue(),
                ps -> {
                    ps.setString(1, pessoa.getNome());
                    ps.setString(2, pessoa.getCpf());
                    ps.setString(3, pessoa.getRg());
                    ps.setDate(4, new Date(pessoa.getDataemissaorg().getTime()));
                    ps.setString(5,pessoa.getUfrg());
                    ps.setBigDecimal(6, pessoa.getRenda());
                    ps.setDate(7, new Date(pessoa.getDatanascimento().getTime()));
                    ps.setString(8, pessoa.getNaturalidae());
                    ps.setString(9, pessoa.getEstadonascimento());
                    ps.setString(10, pessoa.getEstadocivil());
                    ps.setString(11, pessoa.getNomepai());
                    ps.setString(12, pessoa.getNomemae());
                    ps.setString(13, pessoa.getEmail());
                    ps.setString(14, pessoa.getIndicacao());
                    ps.setString(15, pessoa.getNumbeneficio());
                    ps.setString(16, pessoa.getMatricula());
                    ps.setString(17, pessoa.getCpf());
                });
    }
}
