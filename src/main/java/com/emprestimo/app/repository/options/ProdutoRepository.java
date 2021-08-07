package com.emprestimo.app.repository.options;


import com.emprestimo.app.Script.options.ProdutoSQL;
import com.emprestimo.app.config.DataBaseConfig;
import com.emprestimo.app.model.options.Produto;
import com.emprestimo.app.repository.rowMappers.options.RowMapperProduto;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ProdutoRepository {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapperProduto rowMapperProduto;

    @Inject
    public ProdutoRepository(@Named(DataBaseConfig.JDBC_DATABASE)JdbcTemplate jdbcTemplate, RowMapperProduto rowMapperProduto) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapperProduto = rowMapperProduto;
    }

    public List<Produto> getAllProduto(){
        return jdbcTemplate.query(ProdutoSQL.SQL_GETPRODUTO.getValue(),rowMapperProduto);
    }

}
