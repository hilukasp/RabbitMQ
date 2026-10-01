package rabbitmq.demo;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PedidoListener {
    @RabbitListener(queues = RabbitConfig.QUEUE_NAME,messageConverter = "messageConverter")
    public void listen(
            Pedido pedido
    ){

        System.out.println(
                """
                    Pedido Recebido!
                        ID: %d
                        quantidade: %d
                       
                    """.formatted(pedido.getId(), pedido.getQuantidade())
        );
    }
}
