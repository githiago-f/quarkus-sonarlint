package br.edu.ifrs.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
  public List<String> itens = new ArrayList<>();
  public double valorTotal;
  private String status = "NOVO";

  public void adicionarItem(String nome, double preco) {
    if (nome == null || nome.length() == 0) {
      System.out.println("Item sem nome");
    }
    itens.add(nome);
    valorTotal += preco;
    if (valorTotal > 1000) {
      System.out.println("Pedido grande!");
    }
  }

  public String resumo() {
    String s = "Pedido: ";
    for (int i = 0; i < itens.size(); i++) {
      s = s + itens.get(i) + ", ";
    }
    return s;
  }

  public void processar() {
    if ("NOVO".equals(status)) {
      System.out.println("Processando pedido novo...");
      status = "PROCESSANDO";
    }
    if ("PROCESSANDO".equals(status)) {
      System.out.println("Ainda processando...");
    }

    int tipo = 2;
    switch (tipo) {
      case 1:
        System.out.println("Tipo 1");
        break;
      case 2:
        System.out.println("Tipo 2");
        break;
    }

    try {
      if (valorTotal < 0)
        throw new IllegalStateException("valor negativo?");
    } catch (Exception e) {
    } finally {
      if (itens.size() == 0) {
        return;
      }
    }
  }

  public void FecharPedido(boolean notificarCliente) {
    if (!"PROCESSANDO".equals(status)) {
      System.out.println("Estado inválido");
    }
    status = "FECHADO";
    if (notificarCliente) {
      System.out.println("Notificando cliente...");
    }
    if (false) {
      System.out.println("Nunca executa");
    }
  }
}
