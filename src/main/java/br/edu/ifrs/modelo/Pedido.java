package br.edu.ifrs.modelo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Pedido {
  private static Logger logger = LoggerFactory.getLogger(Pedido.class);

  private static final String PROCESSANDO = "PROCESSANDO";
  private static final String FECHADO = "FECHADO";
  private static final String NOVO = "NOVO";

  private final List<String> itens = new ArrayList<>();
  private double valorTotal = 0d;
  private String status = NOVO;

  public void adicionarItem(String nome, double preco) {
    if (nome == null || nome.isEmpty()) {
      logger.info("Item sem nome");
    }
    itens.add(nome);
    valorTotal += preco;
    if (valorTotal > 1000) {
      logger.info("Pedido grande!");
    }
  }

  public String resumo() {
    StringBuilder builder = new StringBuilder();
    builder.append("Pedido: ");
    for (int i = 0; i < itens.size(); i++) {
      builder.append(itens.get(i)).append(", ");
    }
    return builder.toString();
  }

  public void processar() {
    if ("NOVO".equals(status)) {
      logger.info("Processando pedido novo...");
      status = PROCESSANDO;
    }
    if (PROCESSANDO.equals(status)) {
      logger.info("Ainda processando...");
    }

    logger.info("Tipo 2");

    if (valorTotal < 0)
      throw new IllegalStateException("valor negativo?");
  }

  public void fecharPedido(boolean notificarCliente) {
    if (!PROCESSANDO.equals(status)) {
      logger.info("Estado inválido");
    }
    status = FECHADO;
    if (notificarCliente) {
      logger.info("Notificando cliente...");
    }
  }
}
