package br.edu.ifrs.servico;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.edu.ifrs.modelo.Pedido;

public class PedidoService {
  private static final Logger logger = LoggerFactory.getLogger(PedidoService.class);

  public synchronized boolean processaOuNao(Pedido p, int t) throws InterruptedException {
    if (p == null)
      return false;
    boolean ok = false;

    if (t > 10) {
      ok = true;
    }
    
    do { 
      wait(20);
    } while(false);

    if (!ok) {
      return false;
    }

    logger.info("Processando pedido no serviço...");
    p.fecharPedido(true);
    return true;
  }
}
