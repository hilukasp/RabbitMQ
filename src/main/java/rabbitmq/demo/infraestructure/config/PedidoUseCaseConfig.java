package rabbitmq.demo.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rabbitmq.demo.domain.pedido.PedidoPublisher;
import rabbitmq.demo.usecase.pedido.CreatePedidoInteractor;
import rabbitmq.demo.usecase.pedido.CreatePedidoUseCase;
import rabbitmq.demo.usecase.pedido.ReceivePedidoInteractor;
import rabbitmq.demo.usecase.pedido.ReceivePedidoUseCase;

@Configuration
public class PedidoUseCaseConfig {

    @Bean
    public CreatePedidoUseCase createPedidoUseCase(PedidoPublisher publisher) {
        return new CreatePedidoInteractor(publisher);
    }

    @Bean
    public ReceivePedidoUseCase receivePedidoUseCase() {
        return new ReceivePedidoInteractor();
    }
}
