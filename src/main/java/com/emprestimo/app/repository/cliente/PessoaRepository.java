package com.emprestimo.app.repository.cliente;

import com.emprestimo.app.Script.BancoSQL;
import com.emprestimo.app.Script.ContatoSQL;
import com.emprestimo.app.Script.EnderecoSQL;
import com.emprestimo.app.Script.PessoaSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.cliente.Pessoa;
import com.emprestimo.app.repository.rowMappers.RowMapperPessoa;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.List;


@Named
public class PessoaRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapperPessoa rowMapperPessoa;

    @Inject
    public PessoaRepository(@Named(DataBaseConfig.JDBC_DATABASE) JdbcTemplate jdbcTemplate, RowMapperPessoa rowMapperPessoa) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapperPessoa = rowMapperPessoa;
    }

    public List<Pessoa> findAll() {
        List<Pessoa> pessoa = jdbcTemplate.query(PessoaSQL.SQL_GET_LIST_PESSOAS.getValue(), rowMapperPessoa);
        return pessoa;
    }

    public Pessoa findByCpf(String cpf) {
        try {
            Pessoa pessoa = jdbcTemplate.queryForObject(PessoaSQL.SQL_GET_CPFPESSOA.getValue(), rowMapperPessoa, new Object[]{cpf});
            return pessoa;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Pessoa findByNome(String nome) {
        Pessoa pessoa = jdbcTemplate.queryForObject(PessoaSQL.SQL_GET_NOMEPESSOA.getValue(), rowMapperPessoa, new Object[]{nome});
        return pessoa;
    }

    public int delete(String cpf) {
        return jdbcTemplate.update(PessoaSQL.SQL_DELETE_CPFPESSOA.getValue(), new Object[]{cpf});
    }


    @Transactional
    public void save(Pessoa pessoa) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(PessoaSQL.SQL_INSERT_PESSOA.getValue(), new String[]{"idpessoa"});
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getCpf());
            ps.setString(3, pessoa.getRg());
            ps.setDate(4, new Date(pessoa.getDataemissaorg().getTime()));
            ps.setString(5, pessoa.getUfrg());
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
            return ps;
        }, keyHolder);


            pessoa.getBancos().stream().forEach(banco->
            jdbcTemplate.update(connection -> {
            PreparedStatement bc = connection.prepareStatement(BancoSQL.SQL_INSERT_BANCO.getValue());
                    bc.setInt(1,banco.getNumbanco());
                    bc.setString(2, banco.getNomebanco());
                    bc.setLong(3, banco.getAgencia());
                    bc.setInt(4, banco.getDigitoagencia());
                    bc.setString(5, banco.getTipoconta());
                    bc.setLong(6, banco.getNumconta());
                    bc.setInt(7, banco.getDigitoconta());
                    bc.setString(8, banco.getStatusconta());
                    bc.setLong(9, keyHolder.getKey().longValue());
                    return bc;
                }));

            pessoa.getContatos().stream().forEach( contato->
            jdbcTemplate.update(connection -> {
                PreparedStatement ct = connection.prepareStatement(ContatoSQL.SQL_INSERT_CONTATO.getValue());
                ct.setString(1, contato.getNumero());
                ct.setString(2, contato.getTipocontato());
                ct.setString(3, contato.getDecricao());
                ct.setLong(4, keyHolder.getKey().longValue());
                return ct;
            }));

            pessoa.getEnderecos().stream().forEach( endereco->
            jdbcTemplate.update(connection -> {
                PreparedStatement en = connection.prepareStatement(EnderecoSQL.SQL_INSERT_ENDERECO.getValue());
                en.setString(1, endereco.getLogradouro());
                en.setLong(2, endereco.getNumero());
                en.setString(3, endereco.getTipologradouro());
                en.setString(4, endereco.getCep());
                en.setString(5, endereco.getUf());
                en.setString(6, endereco.getBairro());
                en.setString(7, endereco.getCidade());
                en.setString(8, endereco.getEstado());
                en.setLong(9, keyHolder.getKey().longValue());
                return en;
            }));

    }


    public Pessoa updateCliente(Pessoa pessoa) {
        jdbcTemplate.update(PessoaSQL.SQL_UPDATE_PESSOA.getValue(),
                ps -> {
                    ps.setString(1, pessoa.getNome());
                    ps.setString(2, pessoa.getCpf());
                    ps.setString(3, pessoa.getRg());
                    ps.setDate(4, new Date(pessoa.getDataemissaorg().getTime()));
                    ps.setString(5, pessoa.getUfrg());
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
        return pessoa;
    }



}
