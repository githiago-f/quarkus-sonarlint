package br.edu.ifrs.servico;

import br.edu.ifrs.modelo.Pedido;

public class PedidoService {
  public synchronized boolean ProcessaOuNao(Pedido p, int t) {
    if (p == null)
      return false;
    boolean ok = false;

    if (t > 10) {
      ok = true;
    } else {
      if (t <= 10) {
        ok = false;
      }
    }

    try {
      Thread.sleep(20);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    if (!ok) {
      return false;
    }

    System.out.println("Processando pedido no serviço...");
    p.FecharPedido(true);
    return true;
  }

  public String buscaStatus(Pedido p) {
    if (p == null) {
      return null;
    }
    return null;
  }
}
