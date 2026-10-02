package rabbitmq.demo.infraestructure.messaging;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbitmq.demo.infraestructure.config.RabbitConfig;
import rabbitmq.demo.usecase.pedido.ReceivePedidoUseCase;

@Component
public class PedidoListener {

    private final ReceivePedidoUseCase receivePedidoUseCase;

    public PedidoListener(ReceivePedidoUseCase receivePedidoUseCase) {
        this.receivePedidoUseCase = receivePedidoUseCase;
    }

    @RabbitListener(queues = RabbitConfig.QUEUE_NAME, messageConverter = "messageConverter")
    public void listen(PedidoMessage message) {
        receivePedidoUseCase.execute(new ReceivePedidoUseCase.Command(
                message.nome_cliente(),
                message.gt_hr_pedido(),
                message.gt_hr_pronto(),
                message.valor_total(),
                message.id_status(),
                message.id_funcionario()
        ));
    }
}
