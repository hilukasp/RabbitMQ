package rabbitmq.demo.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import rabbitmq.demo.Pedido;
import rabbitmq.demo.RabbitConfig;

@RestController
public class PedidoController {
    private final RabbitTemplate template;

    public PedidoController(RabbitTemplate template) {
        this.template = template;
    }

    @PostMapping
    public ResponseEntity<Void> enviar(){
        Pedido pedido=new Pedido();
        pedido.setQuantidade(3);

        template.convertAndSend(RabbitConfig.EXCHANGE_NAME,RabbitConfig.ROUTING_KEY_NAME);
        return ResponseEntity.accepted().build();
    }
}
