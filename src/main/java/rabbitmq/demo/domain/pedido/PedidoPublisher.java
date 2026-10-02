package rabbitmq.demo.domain.pedido;

public interface PedidoPublisher {
    void publish(Pedido pedido);
}
