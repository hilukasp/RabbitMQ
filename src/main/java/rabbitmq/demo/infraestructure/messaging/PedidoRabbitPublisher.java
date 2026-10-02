package rabbitmq.demo.infraestructure.messaging;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import rabbitmq.demo.domain.pedido.Pedido;
import rabbitmq.demo.domain.pedido.PedidoPublisher;
import rabbitmq.demo.infraestructure.config.RabbitConfig;

@Component
public class PedidoRabbitPublisher implements PedidoPublisher {

    private final RabbitTemplate template;

    public PedidoRabbitPublisher(RabbitTemplate template) {
        this.template = template;
    }

    @Override
    public void publish(Pedido pedido) {
        template.convertAndSend(
                RabbitConfig.EXCHANGE_NAME,
                RabbitConfig.ROUTING_KEY_NAME,
                PedidoMessage.from(pedido)
        );
    }
}
