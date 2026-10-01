package rabbitmq.demo;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
public class RabbitConfig {
    /*
    Direct Exchange - Rotear mensagens
    Queue - Fila
    Binding - Rota entre exchange e queue
     */
    public static final String EXCHANGE_NAME ="exchange_pedido";
    public static final String QUEUE_NAME ="queue_pedido";
    public static final String ROUTING_KEY_NAME ="key_pedido";

    @Bean
    public DirectExchange getDirectExchange(){
        return new DirectExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue getQueue(){
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    @Bean
    public Binding getBinding(
      Queue fila,
      DirectExchange exchange
    ){
        return BindingBuilder.bind(fila).to(exchange).with(ROUTING_KEY_NAME);
    }

    @Bean
    public JacksonJsonMessageConverter messageConverter(){
        return new JacksonJsonMessageConverter();
    }

    @RestController
    public static class PedidoController {
        private final RabbitTemplate template;

        public PedidoController(RabbitTemplate template) {
            this.template = template;
        }

        @PostMapping
        public ResponseEntity<Void> enviar(){
            Pedido pedido=new Pedido();
            pedido.setQuantidade(3);

            template.convertAndSend(EXCHANGE_NAME, ROUTING_KEY_NAME);
            return ResponseEntity.accepted().build();
        }
    }
}
