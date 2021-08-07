package com.emprestimo.app.repository.rowMappers.options;

import com.emprestimo.app.model.options.Produto;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class RowMapperProduto implements RowMapper<Produto> {

    @Override
    public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Produto.builder()
                .idproduto(rs.getLong("idproduto"))
                .produto(rs.getString("produto"))
                .build();
    }
}
