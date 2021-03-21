package com.emprestimo.app.model;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class Cliente {

  private long id;
  private String name;
  private String email;

}
