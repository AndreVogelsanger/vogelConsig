package com.emprestimo.app.repository;

import com.emprestimo.app.model.cliente.Pessoa;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
@AllArgsConstructor
public class CustomerRowMapper implements RowMapper<Pessoa> {

    @Override
    public Pessoa mapRow(ResultSet rs, int rowNum) throws SQLException {

        var pessoa = new Pessoa();

        pessoa.setIdpessoa(rs.getLong("idpessoa"));
        pessoa.setNome(rs.getString("nome"));
        pessoa.setCpf(rs.getString("cpf"));
        pessoa.setRg(rs.getString("rg"));
        pessoa.setDataemissaorg(rs.getDate("dataemissaorg"));
        pessoa.setUfrg(rs.getString("ufrg"));
        pessoa.setRenda(rs.getBigDecimal("renda"));
        pessoa.setDatanascimento(rs.getDate("datanascimento"));
        pessoa.setNaturalidae(rs.getString("naturalidae"));
        pessoa.setEstadonascimento(rs.getString("estadonascimento"));
        pessoa.setEstadocivil(rs.getString("estadocivil"));
        pessoa.setNomepai(rs.getString("nomepai"));
        pessoa.setNomemae(rs.getString("nomemae"));
        pessoa.setEmail(rs.getString("email"));
        pessoa.setIndicacao(rs.getString("indicacao"));
        pessoa.setNumbeneficio(rs.getString("numbeneficio"));
        pessoa.setMatricula(rs.getString("matricula"));

        return pessoa;

    }

}
