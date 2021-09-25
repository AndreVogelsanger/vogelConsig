package com.emprestimo.app.Script.options;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EmpregadorSQL {

    SQL_GETEMPREGADOR ("SELECT * FROM EMPREGADORES ORDER BY 2 ASC");

    public String value;

}
