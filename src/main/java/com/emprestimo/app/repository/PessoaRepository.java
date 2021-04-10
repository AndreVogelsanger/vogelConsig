package com.emprestimo.app.repository;

import com.emprestimo.app.Scripty.PessoaSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.Pessoa;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


@Named
public class PessoaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Inject
    public PessoaRepository(@Named(DataBaseConfig.JDBC_DATABASE) JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Pessoa getCliente(String nome){
        return jdbcTemplate.queryForObject(PessoaSQL.SQL_GET_NOMEPESSOA.getValue(), new Object[]{nome},
                (rs, rowNum) ->
                        Pessoa.builder()
                                .IDPESSOA(rs.getInt("IDPESSOA"))
                                .NOME(rs.getString("NOME"))
                                .CPF(rs.getString("CPF"))
                                .NUMBENEFICIO(rs.getString("NUMBENEFICIO"))
                                .RENDA(rs.getBigDecimal("RENDA"))
                                .DATA_NASCIMENTO(rs.getDate("DATA_NASCIMENTO"))
                                .ENDERECO(rs.getString("ENDERECO"))
                                .CEP(rs.getString("CEP"))
                                .UF(rs.getString("UF"))
                                .CIDADE(rs.getString("CIDADE"))
                                .EMAIL(rs.getString("EMAIL"))
                                .CELULAR(rs.getString("CELULAR"))
                                .TELEFONE(rs.getString("TELEFONE"))
                                .build());
    }

    public Pessoa getCpf(String cpf){
        return jdbcTemplate.queryForObject(PessoaSQL.SQL_GET_CPFPESSOA.getValue(), new Object[]{cpf},
                (rs, rowNum) ->
                        Pessoa.builder()
                                .IDPESSOA(rs.getInt("IDPESSOA"))
                                .NOME(rs.getString("NOME"))
                                .CPF(rs.getString("CPF"))
                                .NUMBENEFICIO(rs.getString("NUMBENEFICIO"))
                                .RENDA(rs.getBigDecimal("RENDA"))
                                .DATA_NASCIMENTO(rs.getDate("DATA_NASCIMENTO"))
                                .ENDERECO(rs.getString("ENDERECO"))
                                .CEP(rs.getString("CEP"))
                                .UF(rs.getString("UF"))
                                .CIDADE(rs.getString("CIDADE"))
                                .EMAIL(rs.getString("EMAIL"))
                                .CELULAR(rs.getString("CELULAR"))
                                .TELEFONE(rs.getString("TELEFONE"))
                                .build());
    }

    public Pessoa getNumBeneficio(String numbeneficio){
        return jdbcTemplate.queryForObject(PessoaSQL.SQL_GET_NBENEFICIOPESSOAS.getValue(), new Object[]{numbeneficio},
                (rs, rowNum) ->
                        Pessoa.builder()
                                .IDPESSOA(rs.getInt("IDPESSOA"))
                                .NOME(rs.getString("NOME"))
                                .CPF(rs.getString("CPF"))
                                .NUMBENEFICIO(rs.getString("NUMBENEFICIO"))
                                .RENDA(rs.getBigDecimal("RENDA"))
                                .DATA_NASCIMENTO(rs.getDate("DATA_NASCIMENTO"))
                                .ENDERECO(rs.getString("ENDERECO"))
                                .CEP(rs.getString("CEP"))
                                .UF(rs.getString("UF"))
                                .CIDADE(rs.getString("CIDADE"))
                                .EMAIL(rs.getString("EMAIL"))
                                .CELULAR(rs.getString("CELULAR"))
                                .TELEFONE(rs.getString("TELEFONE"))
                                .build());
    }

    public List<Pessoa> getClienteList(){
        return jdbcTemplate.query (PessoaSQL.SQL_GET_LIST_PESSOAS.getValue(),
                (rs, rowNum) ->
                        Pessoa.builder()
                                .IDPESSOA(rs.getInt("IDPESSOA"))
                                .NOME(rs.getString("NOME"))
                                .CPF(rs.getString("CPF"))
                                .NUMBENEFICIO(rs.getString("NUMBENEFICIO"))
                                .RENDA(rs.getBigDecimal("RENDA"))
                                .DATA_NASCIMENTO(rs.getDate("DATA_NASCIMENTO"))
                                .ENDERECO(rs.getString("ENDERECO"))
                                .CEP(rs.getString("CEP"))
                                .UF(rs.getString("UF"))
                                .CIDADE(rs.getString("CIDADE"))
                                .EMAIL(rs.getString("EMAIL"))
                                .CELULAR(rs.getString("CELULAR"))
                                .TELEFONE(rs.getString("TELEFONE"))
                                .build());
    }
    // LER DOCUMENTAÇÃO DO JDBCTEPLATE PARA ENTEDER OS METODOS A SEREM APLICADOS
    // DOCUMENTAÇÃO DO W3C - ARQUITETURA WEB
    public void postClienteNovo(Pessoa pessoa){
         jdbcTemplate.update(PessoaSQL.SQL_INSERT_PESSOA.getValue(),
                new PreparedStatementSetter(){
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, pessoa.getNOME());
                        ps.setString(2, pessoa.getCPF());
                        ps.setString(3, pessoa.getNUMBENEFICIO());
                        ps.setBigDecimal(4,pessoa.getRENDA());
                        ps.setDate(5, new java.sql.Date(pessoa.getDATA_NASCIMENTO().getTime())); // VERIFICAR DATA
                        ps.setString(6,pessoa.getENDERECO());
                        ps.setString(7, pessoa.getCEP());
                        ps.setString(8, pessoa.getUF());
                        ps.setString(9, pessoa.getCIDADE());
                        ps.setString(10, pessoa.getEMAIL());
                        ps.setString(11, pessoa.getCELULAR());
                        ps.setString(12, pessoa.getTELEFONE());
                    }
                });

    }


    public int getCpfDeletar(Pessoa pessoa) {
        return jdbcTemplate.update(PessoaSQL.SQL_DELETE_CPFPESSOA.getValue(), new Object[]{pessoa.getCPF()});
    }

    public int getNumBeneficioDeletar(Pessoa pessoa){
        return jdbcTemplate.update(PessoaSQL.SQL_DELETE_NUMBENEFICIOPESSOA.getValue(),new Object[]{pessoa.getNUMBENEFICIO()});
   }


    public void putCpfAtualizar(Pessoa pessoa){
        jdbcTemplate.update(PessoaSQL.SQL_UPDATE_PESSOA.getValue(),
                new PreparedStatementSetter(){
                    public void setValues(PreparedStatement ps) throws SQLException {
                        ps.setString(1, pessoa.getNOME());
                        ps.setString(2, pessoa.getCPF());
                        ps.setString(3, pessoa.getNUMBENEFICIO());
                        ps.setBigDecimal(4,pessoa.getRENDA());
                        ps.setDate(5, new java.sql.Date(pessoa.getDATA_NASCIMENTO().getTime())); // VERIFICAR DATA
                        ps.setString(6,pessoa.getENDERECO());
                        ps.setString(7, pessoa.getCEP());
                        ps.setString(8, pessoa.getUF());
                        ps.setString(9, pessoa.getCIDADE());
                        ps.setString(10, pessoa.getEMAIL());
                        ps.setString(11, pessoa.getCELULAR());
                        ps.setString(12, pessoa.getTELEFONE());
                        ps.setString(13, pessoa.getCPF());
                    }
                });
    }


}
