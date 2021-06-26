package com.emprestimo.app.repository.cliente.cliente;

import com.emprestimo.app.Scripty.cliente.BancoSQL;
import com.emprestimo.app.Scripty.cliente.ContatoSQL;
import com.emprestimo.app.Scripty.cliente.EnderecoSQL;
import com.emprestimo.app.Scripty.cliente.PessoaSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.dto.cliente.BancoDto;
import com.emprestimo.app.dto.cliente.ContatoDto;
import com.emprestimo.app.dto.cliente.EnderecoDto;
import com.emprestimo.app.model.cliente.Banco;
import com.emprestimo.app.model.cliente.Contato;
import com.emprestimo.app.model.cliente.Endereco;
import com.emprestimo.app.model.cliente.Pessoa;
import com.emprestimo.app.repository.cliente.rowMappers.RowMapperPessoa;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.expression.spel.ast.IntLiteral;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.inject.Named;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
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
        Banco banco = new Banco();
        Endereco endereco = new Endereco();
        Contato contato = new Contato();

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


            pessoa.getBancos().stream().forEach(i->
            jdbcTemplate.update(connection -> {
            PreparedStatement bc = connection.prepareStatement(BancoSQL.SQL_INSERT_BANCO.getValue());
                    bc.setInt(1,pessoa.getBancos().get(0).getNumbanco());
                    bc.setString(2, pessoa.getBancos().get(0).getNomebanco());
                    bc.setLong(3, pessoa.getBancos().get(0).getAgencia());
                    bc.setInt(4, pessoa.getBancos().get(0).getDigitoagencia());
                    bc.setString(5, pessoa.getBancos().get(0).getTipoconta());
                    bc.setLong(6, pessoa.getBancos().get(0).getNumconta());
                    bc.setInt(7, pessoa.getBancos().get(0).getDigitoconta());
                    bc.setString(8, pessoa.getBancos().get(0).getStatusconta());
                    bc.setLong(9, keyHolder.getKey().longValue());
                    return bc;
                }));

            pessoa.getContatos().stream().forEach( i->
            jdbcTemplate.update(connection -> {
                PreparedStatement ct = connection.prepareStatement(ContatoSQL.SQL_INSERT_CONTATO.getValue());
                ct.setString(1, pessoa.getContatos().get(0).getNumero());
                ct.setString(2, pessoa.getContatos().get(0).getTipocontato());
                ct.setString(3, pessoa.getContatos().get(0).getDecricao());
                ct.setLong(4, keyHolder.getKey().longValue());
                return ct;
            }));

            pessoa.getEnderecos().stream().forEach( i->
            jdbcTemplate.update(connection -> {
                PreparedStatement en = connection.prepareStatement(EnderecoSQL.SQL_INSERT_ENDERECO.getValue());
                en.setString(1, pessoa.getEnderecos().get(0).getLogradouro());
                en.setLong(2, pessoa.getEnderecos().get(0).getNumero());
                en.setString(3, pessoa.getEnderecos().get(0).getTipologradouro());
                en.setString(4, pessoa.getEnderecos().get(0).getCep());
                en.setString(5, pessoa.getEnderecos().get(0).getUf());
                en.setString(6, pessoa.getEnderecos().get(0).getBairro());
                en.setString(7, pessoa.getEnderecos().get(0).getCidade());
                en.setString(8, pessoa.getEnderecos().get(0).getEstado());
                en.setLong(9, keyHolder.getKey().longValue());
                return en;
            }));

    }


    public Pessoa update(Pessoa pessoa) {
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
