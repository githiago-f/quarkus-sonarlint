package br.edu.ifrs.modelo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Cliente {
  private static Logger logger = LoggerFactory.getLogger(Cliente.class);

  private final String nome;
  private final String email;
  private final int idade;
  private final Date cadastro;

  public Cliente(String nome, String email, int idade) {
    this.nome = nome;
    this.email = email;
    this.idade = idade;
    cadastro = new Date();
  }

  public boolean valida() {
    if (nome == null || email == null) {
      logger.info("Dados inválidos");
      return false;
    }
    if (nome.isEmpty()) {
      logger.info("Nome vazio");
    }
    if (idade < 0 || idade > 200) {
      logger.info("Idade estranha");
    }
    return true;
  }

  public String getEmail() {
    return email.trim();
  }

  public Date cadastro() {
    return cadastro;
  }

  @Override
  public boolean equals(Object o) {
    if (o instanceof Cliente c) {
      return this.email == c.email;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return 42;
  }
}
